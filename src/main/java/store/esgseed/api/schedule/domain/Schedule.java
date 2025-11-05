package store.esgseed.api.schedule.domain;

import jakarta.persistence.*;
import lombok.*;
import store.esgseed.api.stadium.domain.Stadium;

import java.time.LocalDate;

/**
 * 일정 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String stadiumUk; // Schedule의 PK
    private LocalDate scheDate;
    private String gubun;
    private Long hometeamId;
    private Long awayteamId;
    private Integer homeScore;
    private Integer awayScore;

    // Stadium과의 다대일 연관관계 (Stadium이 부모)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

}
