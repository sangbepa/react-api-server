package store.esgseed.api.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.team.domain.TeamEntity;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    
    List<TeamEntity> findByTeamNameContaining(String teamName);
    
    List<TeamEntity> findByRegionName(String regionName);
}

