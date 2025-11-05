package store.esgseed.api.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.stadium.domain.Stadium;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    List<Stadium> findByStadiumNameContaining(String stadiumName);

    List<Stadium> findByHometeamId(Long hometeamId);
}
