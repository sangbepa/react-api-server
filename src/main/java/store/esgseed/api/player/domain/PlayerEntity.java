package store.esgseed.api.player.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * 선수 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

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
}
