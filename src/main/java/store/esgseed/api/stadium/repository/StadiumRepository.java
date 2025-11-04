package store.esgseed.api.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.stadium.domain.StadiumEntity;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<StadiumEntity, Long> {

    List<StadiumEntity> findByStadiumNameContaining(String stadiumName);

    List<StadiumEntity> findByHomeTeamId(Long homeTeamId);
}
