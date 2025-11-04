package store.esgseed.api.stadium.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * 경기장 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "stadiums")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StadiumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stadiumId;

    private String stadiumName;
    private Long homeTeamId; // FK 아님, 정보용
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;
}
