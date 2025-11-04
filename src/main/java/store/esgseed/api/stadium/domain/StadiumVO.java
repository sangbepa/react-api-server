package store.esgseed.api.stadium.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 경기장 Value Object - 불변 객체
 */
@Getter
@AllArgsConstructor
public class StadiumVO {

    private final Long stadiumId;
    private final String stadiumName;
    private final Long homeTeamId;
    private final Integer seatCount;
    private final String address;
    private final String ddd;
    private final String tel;
}

