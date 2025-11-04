package store.esgseed.api.team.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.esgseed.api.common.Messenger;
import store.esgseed.api.team.domain.TeamDTO;
import store.esgseed.api.team.service.TeamService;

import java.util.List;

/**
 * 팀 API 컨트롤러
 */
@Tag(name = "Team API", description = "팀 데이터 관리 API")
@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @Operation(summary = "팀 데이터 생성", description = "새로운 팀 데이터를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping
    public Messenger<TeamDTO> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "생성할 팀 데이터", required = true)
            @RequestBody TeamDTO dto) {
        TeamDTO response = teamService.create(dto);
        return Messenger.created("팀 데이터가 생성되었습니다.", response);
    }

    @Operation(summary = "팀 데이터 조회", description = "ID로 특정 팀 데이터를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @GetMapping("/{id}")
    public Messenger<TeamDTO> getById(
            @Parameter(description = "조회할 팀 ID", required = true)
            @PathVariable Long id) {
        TeamDTO response = teamService.getById(id);
        return Messenger.ok(response);
    }

    @Operation(summary = "팀 데이터 목록 조회",
               description = "모든 팀 데이터를 조회하거나 팀명/연고지로 검색합니다.")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping
    public Messenger<List<TeamDTO>> getAll(
            @Parameter(description = "검색할 팀명 (선택)", required = false)
            @RequestParam(required = false) String name,
            @Parameter(description = "검색할 연고지 (선택)", required = false)
            @RequestParam(required = false) String region) {
        List<TeamDTO> responses;

        if (name != null) {
            responses = teamService.searchByName(name);
        } else if (region != null) {
            responses = teamService.getByRegion(region);
        } else {
            responses = teamService.getAll();
        }

        return Messenger.ok(responses);
    }

    @Operation(summary = "팀 데이터 수정", description = "기존 팀 데이터를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @PutMapping("/{id}")
    public Messenger<TeamDTO> update(
            @Parameter(description = "수정할 팀 ID", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "수정할 팀 데이터", required = true)
            @RequestBody TeamDTO dto) {
        TeamDTO response = teamService.update(id, dto);
        return Messenger.ok("팀 데이터가 수정되었습니다.", response);
    }

    @Operation(summary = "팀 데이터 삭제", description = "ID로 특정 팀 데이터를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "데이터 없음")
    })
    @DeleteMapping("/{id}")
    public Messenger<Void> delete(
            @Parameter(description = "삭제할 팀 ID", required = true)
            @PathVariable Long id) {
        teamService.delete(id);
        return Messenger.noContent("팀 데이터가 삭제되었습니다.");
    }
}

