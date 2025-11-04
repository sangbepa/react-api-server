package store.esgseed.api.player.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 선수 Value Object - 불변 객체
 */
@Getter
@AllArgsConstructor
public class PlayerVO {

    private final Long playerId;
    private final String playerName;
    private final String ePlayerName;
    private final String nickname;
    private final Integer joinYyyy;
    private final String position;
    private final Integer backNo;
    private final String nation;
    private final LocalDate birthDate;
    private final String solar;
    private final Double height;
    private final Double weight;
}

