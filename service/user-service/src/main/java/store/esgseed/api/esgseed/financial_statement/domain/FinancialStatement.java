package store.esgseed.api.esgseed.financial_statement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 재무제표 엔티티 - 추후 필드 확장 예정
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FinancialStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
