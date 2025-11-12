package store.esgseed.api.emission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.emission.domain.Emission;

import java.util.List;

@Repository
public interface EmissionRepository extends JpaRepository<Emission, Long> {
    
    List<Emission> findBySiteContaining(String site);
}

