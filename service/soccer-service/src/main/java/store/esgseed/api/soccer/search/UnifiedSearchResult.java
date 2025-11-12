package store.esgseed.api.soccer.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.esgseed.api.soccer.player.domain.PlayerDTO;
import store.esgseed.api.soccer.team.domain.TeamDTO;
import store.esgseed.api.soccer.stadium.domain.StadiumDTO;
import store.esgseed.api.soccer.schedule.domain.ScheduleDTO;

import java.util.List;

/**
 * 통합 검색 결과 DTO
 * Player, Team, Stadium, Schedule 검색 결과를 모두 포함
 */
@Schema(description = "통합 검색 결과")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnifiedSearchResult {

    @Schema(description = "검색된 선수 목록")
    private List<PlayerDTO> players;

    @Schema(description = "검색된 팀 목록")
    private List<TeamDTO> teams;

    @Schema(description = "검색된 경기장 목록")
    private List<StadiumDTO> stadiums;

    @Schema(description = "검색된 일정 목록")
    private List<ScheduleDTO> schedules;

    @Schema(description = "총 검색 결과 수")
    public int getTotalCount() {
        return (players != null ? players.size() : 0)
             + (teams != null ? teams.size() : 0)
             + (stadiums != null ? stadiums.size() : 0)
             + (schedules != null ? schedules.size() : 0);
    }
}

