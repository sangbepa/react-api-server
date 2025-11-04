package store.esgseed.api.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.player.domain.PlayerEntity;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    
    List<PlayerEntity> findByPlayerNameContaining(String playerName);
    
    List<PlayerEntity> findByPosition(String position);
}

