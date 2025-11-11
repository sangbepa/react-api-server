package store.esgseed.api.soccer.search;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.esgseed.api.soccer.player.service.PlayerService;
import store.esgseed.api.soccer.team.service.TeamService;
import store.esgseed.api.soccer.stadium.service.StadiumService;
import store.esgseed.api.soccer.schedule.service.ScheduleService;

import java.util.ArrayList;

/**
 * 통합 검색 퍼사드 서비스
 * 여러 엔티티를 한 번에 검색하여 통합 결과 반환
 */
@Service
@RequiredArgsConstructor
public class SearchFacadeService {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final StadiumService stadiumService;
    private final ScheduleService scheduleService;

    /**
     * 키워드로 모든 엔티티 검색
     * @param keyword 검색어
     * @return 통합 검색 결과
     */
    public UnifiedSearchResult findByKeyword(String keyword) {
        System.out.println("📦 SearchFacadeService.findByKeyword() 시작");
        System.out.println("   검색어: " + keyword);
        
        UnifiedSearchResult result = new UnifiedSearchResult();
        
        try {
            // 1. Player 검색
            System.out.println("   🔹 Player 검색 중...");
            var players = playerService.searchByName(keyword);
            result.setPlayers(players);
            System.out.println("   ✅ Player 검색 완료: " + players.size() + "건");
            
        } catch (Exception e) {
            System.out.println("   ❌ Player 검색 실패: " + e.getMessage());
            result.setPlayers(new ArrayList<>());
        }

        try {
            // 2. Team 검색
            System.out.println("   🔹 Team 검색 중...");
            var teams = teamService.searchByName(keyword);
            result.setTeams(teams);
            System.out.println("   ✅ Team 검색 완료: " + teams.size() + "건");
            
        } catch (Exception e) {
            System.out.println("   ❌ Team 검색 실패: " + e.getMessage());
            result.setTeams(new ArrayList<>());
        }

        try {
            // 3. Stadium 검색
            System.out.println("   🔹 Stadium 검색 중...");
            var stadiums = stadiumService.searchByName(keyword);
            result.setStadiums(stadiums);
            System.out.println("   ✅ Stadium 검색 완료: " + stadiums.size() + "건");
            
        } catch (Exception e) {
            System.out.println("   ❌ Stadium 검색 실패: " + e.getMessage());
            result.setStadiums(new ArrayList<>());
        }

        try {
            // 4. Schedule 검색 (구분명으로 검색)
            System.out.println("   🔹 Schedule 검색 중...");
            var schedules = scheduleService.getByGubun(keyword);
            result.setSchedules(schedules);
            System.out.println("   ✅ Schedule 검색 완료: " + schedules.size() + "건");
            
        } catch (Exception e) {
            System.out.println("   ❌ Schedule 검색 실패: " + e.getMessage());
            result.setSchedules(new ArrayList<>());
        }

        int totalCount = result.getPlayers().size() 
                       + result.getTeams().size() 
                       + result.getStadiums().size() 
                       + result.getSchedules().size();
        
        System.out.println("📦 SearchFacadeService.findByKeyword() 완료");
        System.out.println("   총 검색 결과: " + totalCount + "건");
        System.out.println("===============================================\n");
        
        return result;
    }
}

