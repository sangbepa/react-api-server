package store.esgseed.api.soccer.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import store.esgseed.api.soccer.player.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    List<Player> findByPlayerNameContaining(String playerName);
    
    List<Player> findByPosition(String position);
}

