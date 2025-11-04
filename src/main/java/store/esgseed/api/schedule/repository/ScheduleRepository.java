package store.esgseed.api.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.esgseed.api.schedule.domain.ScheduleEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    
    List<ScheduleEntity> findByScheDate(LocalDate scheDate);
    
    List<ScheduleEntity> findByHomeTeamId(Long homeTeamId);
    
    List<ScheduleEntity> findByAwayTeamId(Long awayTeamId);
    
    List<ScheduleEntity> findByGubun(String gubun);
}

