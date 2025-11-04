package store.esgseed.api.schedule.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

/**
 * 일정 DTO - API 요청/응답 데이터
 */
@Schema(description = "일정 데이터 모델")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDTO {

    @Schema(description = "일정 ID", example = "1")
    private Long id;

    @Schema(description = "경기 날짜", example = "2024-03-15")
    private LocalDate scheDate;

    @Schema(description = "경기 구분", example = "정규리그")
    private String gubun;

    @Schema(description = "홈팀 ID", example = "1")
    private Long homeTeamId;

    @Schema(description = "원정팀 ID", example = "2")
    private Long awayTeamId;

    @Schema(description = "홈팀 득점", example = "3")
    private Integer homeScore;

    @Schema(description = "원정팀 득점", example = "2")
    private Integer awayScore;
}

