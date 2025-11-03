package store.esgseed.api.emission.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 배출량 엔티티 - 데이터베이스 테이블과 매핑
 */
@Entity
@Table(name = "emissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EmissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String site; // 사업장

    @Column(nullable = false, precision = 19, scale = 3)
    private BigDecimal scope1Tco2e; // Scope 1 배출량

    @Column(nullable = false, precision = 19, scale = 3)
    private BigDecimal scope2Tco2e; // Scope 2 배출량

    @Column(nullable = false, precision = 19, scale = 3)
    private BigDecimal totalScope12Tco2e; // Scope 1+2 총 배출량

    @Column(precision = 19, scale = 3)
    private BigDecimal scope3Tco2e; // Scope 3 배출량 (선택)

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
