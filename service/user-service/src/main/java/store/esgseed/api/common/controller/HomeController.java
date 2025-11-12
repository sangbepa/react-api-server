package store.esgseed.api.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.esgseed.api.common.Messenger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Home API 컨트롤러
 * Messenger를 활용한 기본 CRUD 구조
 */
@Tag(name = "Home API", description = "홈 데이터 관리 API")
@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    // 간단한 인메모리 저장소
    private final Map<Long, HomeData> dataStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * 홈 데이터 생성
     * POST /api/home
     */
    @Operation(summary = "홈 데이터 생성", description = "새로운 홈 데이터를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "생성 성공", content = @Content(schema = @Schema(implementation = Messenger.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping
    public Messenger<HomeData> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "생성할 홈 데이터", required = true) @RequestBody HomeDataRequest request) {
        Long newId = idGenerator.getAndIncrement();

        return Messenger.created("데이터가 생성되었습니다.",
                dataStore.computeIfAbsent(newId, id -> HomeData.builder()
                        .id(id)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()));
    }

    /**
     * ID로 홈 데이터 조회
     * GET /api/home/{id}
     */
    @Operation(summary = "홈 데이터 조회", description = "ID로 특정 홈 데이터를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @GetMapping("/{id}")
    public Messenger<HomeData> getById(
            @Parameter(description = "조회할 데이터 ID", required = true) @PathVariable Long id) {
        return dataStore.containsKey(id)
                ? Messenger.ok(dataStore.get(id))
                : Messenger.notFound("ID " + id + "에 해당하는 데이터를 찾을 수 없습니다.");
    }

    /**
     * 모든 홈 데이터 조회
     * GET /api/home
     */
    @Operation(summary = "전체 홈 데이터 조회", description = "저장된 모든 홈 데이터를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping
    public Messenger<List<HomeData>> getAll() {
        return Messenger.ok(
                dataStore.isEmpty() ? "조회된 데이터가 없습니다." : "데이터 조회 완료",
                dataStore.values().stream().toList());
    }

    /**
     * 홈 데이터 수정
     * PUT /api/home/{id}
     */
    @Operation(summary = "홈 데이터 수정", description = "기존 홈 데이터를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @PutMapping("/{id}")
    public Messenger<HomeData> update(
            @Parameter(description = "수정할 데이터 ID", required = true) @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "수정할 홈 데이터", required = true) @RequestBody HomeDataRequest request) {
        return dataStore.containsKey(id)
                ? Messenger.ok("데이터가 수정되었습니다.",
                        dataStore.compute(id, (key, oldValue) -> HomeData.builder()
                                .id(key)
                                .title(request.getTitle())
                                .content(request.getContent())
                                .build()))
                : Messenger.notFound("ID " + id + "에 해당하는 데이터를 찾을 수 없습니다.");
    }

    /**
     * 홈 데이터 삭제
     * DELETE /api/home/{id}
     */
    @Operation(summary = "홈 데이터 삭제", description = "ID로 특정 홈 데이터를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @DeleteMapping("/{id}")
    public Messenger<Void> delete(
            @Parameter(description = "삭제할 데이터 ID", required = true) @PathVariable Long id) {
        return dataStore.remove(id) != null
                ? Messenger.noContent("데이터가 삭제되었습니다.")
                : Messenger.notFound("ID " + id + "에 해당하는 데이터를 찾을 수 없습니다.");
    }

    /**
     * 서버 상태 확인
     * GET /api/home/health
     */
    @Operation(summary = "서버 상태 확인", description = "서버의 현재 상태와 통계를 확인합니다.")
    @ApiResponse(responseCode = "200", description = "서버 정상")
    @GetMapping("/health")
    public Messenger<Map<String, Object>> health() {
        return Messenger.ok("서버가 정상적으로 동작 중입니다.",
                Map.of(
                        "status", "UP",
                        "service", "ESG Seed API",
                        "version", "1.0.0",
                        "dataCount", dataStore.size()));
    }

    /**
     * 홈 데이터 DTO (Builder 패턴 사용)
     */
    @Schema(description = "홈 데이터 응답 모델")
    @Getter
    @Builder
    public static class HomeData {
        @Schema(description = "데이터 ID", example = "1")
        private Long id;

        @Schema(description = "제목", example = "샘플 제목")
        private String title;

        @Schema(description = "내용", example = "샘플 내용입니다.")
        private String content;
    }

    /**
     * 홈 데이터 요청 DTO (Builder 패턴 사용)
     */
    @Schema(description = "홈 데이터 요청 모델")
    @Getter
    @Builder
    public static class HomeDataRequest {
        @Schema(description = "제목", example = "새로운 제목", required = true)
        private String title;

        @Schema(description = "내용", example = "새로운 내용입니다.", required = true)
        private String content;
    }
}
