package store.esgseed.api.emission.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * 배출량 엔티티 - 데이터베이스 테이블과 매핑
 * DTO 기반으로 타입을 String으로 통일
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

    @Column(nullable = false)
    private String scope1Tco2e; // Scope 1 배출량

    @Column(nullable = false)
    private String scope2Tco2e; // Scope 2 배출량

    @Column(nullable = false)
    private String totalScope12Tco2e; // Scope 1+2 총 배출량

    @Column
    private String scope3Tco2e; // Scope 3 배출량 (선택)
}
