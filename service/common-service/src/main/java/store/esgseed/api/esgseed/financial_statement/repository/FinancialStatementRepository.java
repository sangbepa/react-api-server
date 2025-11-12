package store.esgseed.api.esgseed.financial_statement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.esgseed.financial_statement.domain.FinancialStatement;

/**
 * 재무제표 데이터 접근 레이어 - 구현 예정
 */
@Repository
public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, Long> {
}
