package store.esgseed.api.esgseed.organiztion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.esgseed.organiztion.domain.Organization;

/**
 * 조직 데이터 접근 레이어 - 구현 예정
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}


