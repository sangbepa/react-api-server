package store.esgseed.api.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.schedule.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
    List<Schedule> findByScheDate(LocalDate scheDate);
    
    List<Schedule> findByHometeamId(Long hometeamId);
    
    List<Schedule> findByAwayteamId(Long awayteamId);
    
    List<Schedule> findByGubun(String gubun);
}

