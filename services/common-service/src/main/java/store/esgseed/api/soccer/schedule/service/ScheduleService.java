package store.esgseed.api.soccer.schedule.service;

import java.util.List;

import store.esgseed.api.soccer.schedule.domain.ScheduleDTO;

public interface ScheduleService {

    ScheduleDTO create(ScheduleDTO dto);

    ScheduleDTO getById(Long id);

    List<ScheduleDTO> getAll();

    List<ScheduleDTO> getByDate(String scheDate);

    List<ScheduleDTO> getByTeam(String teamUk);

    List<ScheduleDTO> getByGubun(String gubun);

    ScheduleDTO update(Long id, ScheduleDTO dto);

    void delete(Long id);
}

