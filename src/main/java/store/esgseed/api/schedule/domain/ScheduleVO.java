package store.esgseed.api.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 일정 Value Object - 불변 객체
 */
@Getter
@AllArgsConstructor
public class ScheduleVO {

    private final Long id;
    private final LocalDate scheDate;
    private final String gubun;
    private final Long homeTeamId;
    private final Long awayTeamId;
    private final Integer homeScore;
    private final Integer awayScore;
}

