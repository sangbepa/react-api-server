package store.esgseed.api.schedule.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * 일정 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 복합키 대신 단일 PK

    private LocalDate scheDate;
    private String gubun;
    private Long homeTeamId;
    private Long awayTeamId;
    private Integer homeScore;
    private Integer awayScore;
}
