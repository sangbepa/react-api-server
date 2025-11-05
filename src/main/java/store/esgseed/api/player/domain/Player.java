package store.esgseed.api.player.domain;

import jakarta.persistence.*;
import lombok.*;
import store.esgseed.api.team.domain.Team;

import java.time.LocalDate;

/**
 * 선수 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String playerUk;

    private String playerName;
    private String ePlayerName;
    private String nickname;
    private Integer joinYyyy;
    private String position;
    private Integer backNo;
    private String nation;
    private LocalDate birthDate;
    private String solar;
    private Double height;
    private Double weight;

    // Team과의 다대일 연관관계 (Team이 부모)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
