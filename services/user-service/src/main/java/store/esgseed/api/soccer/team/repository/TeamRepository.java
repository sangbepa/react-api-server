package store.esgseed.api.soccer.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.esgseed.api.soccer.team.domain.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    
    List<Team> findByTeamNameContaining(String teamName);
    
    List<Team> findByRegionName(String regionName);
}

