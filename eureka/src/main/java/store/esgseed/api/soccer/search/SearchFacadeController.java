package store.esgseed.api.soccer.search;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 통합 검색 퍼사드 컨트롤러
 * Player, Team, Stadium, Schedule을 통합 검색
 */
@Tag(name = "Search Facade API", description = "축구 데이터 통합 검색 API")
@RestController
@RequestMapping("/api/soccer/search")
@CrossOrigin(origins = "http://localhost:3000", // 허용할 출처
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, // 허용할 HTTP 메서드
        allowedHeaders = "*", // 허용할 헤더
        allowCredentials = "true", // 쿠키/인증 허용
        maxAge = 3600 // preflight 캐시 시간(초)
)
@RequiredArgsConstructor
public class SearchFacadeController {

    private final SearchFacadeService searchFacadeService;

    @Operation(summary = "통합 검색", description = "키워드로 선수, 팀, 경기장, 일정을 모두 검색합니다.")
    @GetMapping
    public UnifiedSearchResult search(
            @Parameter(description = "검색 키워드", required = true, example = "손흥민") @RequestParam String keyword) {

        System.out.println("===============================================");
        System.out.println("🔍 통합 검색 요청 받음");
        System.out.println("검색어 (keyword): " + keyword);
        System.out.println("===============================================");

        return searchFacadeService.findByKeyword(keyword);
    }
}
