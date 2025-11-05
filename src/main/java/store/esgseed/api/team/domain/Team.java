package store.esgseed.api.team.domain;

import jakarta.persistence.*;
import lombok.*;
import store.esgseed.api.stadium.domain.Stadium;

/**
 * 팀 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String teamUk;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private Integer origYyyy;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;

    // Stadium과의 일대일 연관관계 (Stadium이 부모)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

}
