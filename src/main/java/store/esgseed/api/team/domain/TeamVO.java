package store.esgseed.api.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 팀 Value Object - 불변 객체
 */
@Getter
@AllArgsConstructor
public class TeamVO {

    private final Long teamId;
    private final String regionName;
    private final String teamName;
    private final String eTeamName;
    private final Integer origYyyy;
    private final String zipCode1;
    private final String zipCode2;
    private final String address;
    private final String ddd;
    private final String tel;
    private final String fax;
    private final String homepage;
    private final String owner;
}
