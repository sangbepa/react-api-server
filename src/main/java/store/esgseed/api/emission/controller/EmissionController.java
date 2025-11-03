package store.esgseed.api.emission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.esgseed.api.common.Messenger;
import store.esgseed.api.emission.domain.EmissionDTO;
import store.esgseed.api.emission.service.EmissionService;

import java.util.List;

/**
 * 배출량 API 컨트롤러
 * Controller는 DTO만 사용
 */
@RestController
@RequestMapping("/api/emissions")
@RequiredArgsConstructor
public class EmissionController {

    private final EmissionService emissionService;

    /**
     * 배출량 데이터 생성
     * POST /api/emissions
     */
    @PostMapping
    public Messenger<EmissionDTO> create(@RequestBody EmissionDTO dto) {
        EmissionDTO response = emissionService.create(dto);
        return Messenger.created("배출량 데이터가 생성되었습니다.", response);
    }

    /**
     * ID로 배출량 데이터 조회
     * GET /api/emissions/{id}
     */
    @GetMapping("/{id}")
    public Messenger<EmissionDTO> getById(@PathVariable Long id) {
        EmissionDTO response = emissionService.getById(id);
        return Messenger.ok(response);
    }

    /**
     * 배출량 데이터 목록 조회 (사업장명 검색 지원)
     * GET /api/emissions
     * GET /api/emissions?site=삼성
     */
    @GetMapping
    public Messenger<List<EmissionDTO>> getAll(@RequestParam(required = false) String site) {
        List<EmissionDTO> responses = site != null
                ? emissionService.searchBySite(site)
                : emissionService.getAll();
        return Messenger.ok(responses);
    }

    /**
     * 배출량 데이터 수정
     * PUT /api/emissions/{id}
     */
    @PutMapping("/{id}")
    public Messenger<EmissionDTO> update(@PathVariable Long id, @RequestBody EmissionDTO dto) {
        EmissionDTO response = emissionService.update(id, dto);
        return Messenger.ok("배출량 데이터가 수정되었습니다.", response);
    }

    /**
     * 배출량 데이터 삭제
     * DELETE /api/emissions/{id}
     */
    @DeleteMapping("/{id}")
    public Messenger<Void> delete(@PathVariable Long id) {
        emissionService.delete(id);
        return Messenger.noContent("배출량 데이터가 삭제되었습니다.");
    }
}
