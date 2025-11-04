package store.esgseed.api.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.esgseed.api.schedule.domain.ScheduleDTO;
import store.esgseed.api.schedule.domain.ScheduleEntity;
import store.esgseed.api.schedule.repository.ScheduleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 일정 서비스 구현체
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public ScheduleDTO create(ScheduleDTO dto) {
        ScheduleEntity entity = ScheduleEntity.builder()
                .scheDate(dto.getScheDate())
                .gubun(dto.getGubun())
                .homeTeamId(dto.getHomeTeamId())
                .awayTeamId(dto.getAwayTeamId())
                .homeScore(dto.getHomeScore())
                .awayScore(dto.getAwayScore())
                .build();

        ScheduleEntity saved = scheduleRepository.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public ScheduleDTO getById(Long id) {
        ScheduleEntity entity = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 데이터를 찾을 수 없습니다. ID: " + id));
        return convertToDTO(entity);
    }

    @Override
    public List<ScheduleDTO> getAll() {
        return scheduleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getByDate(LocalDate scheDate) {
        return scheduleRepository.findByScheDate(scheDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getByTeam(Long teamId) {
        List<ScheduleEntity> homeGames = scheduleRepository.findByHomeTeamId(teamId);
        List<ScheduleEntity> awayGames = scheduleRepository.findByAwayTeamId(teamId);

        return Stream.concat(homeGames.stream(), awayGames.stream())
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getByGubun(String gubun) {
        return scheduleRepository.findByGubun(gubun).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ScheduleDTO update(Long id, ScheduleDTO dto) {
        ScheduleEntity entity = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 데이터를 찾을 수 없습니다. ID: " + id));

        entity.setScheDate(dto.getScheDate());
        entity.setGubun(dto.getGubun());
        entity.setHomeTeamId(dto.getHomeTeamId());
        entity.setAwayTeamId(dto.getAwayTeamId());
        entity.setHomeScore(dto.getHomeScore());
        entity.setAwayScore(dto.getAwayScore());

        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("일정 데이터를 찾을 수 없습니다. ID: " + id);
        }
        scheduleRepository.deleteById(id);
    }

    private ScheduleDTO convertToDTO(ScheduleEntity entity) {
        return ScheduleDTO.builder()
                .id(entity.getId())
                .scheDate(entity.getScheDate())
                .gubun(entity.getGubun())
                .homeTeamId(entity.getHomeTeamId())
                .awayTeamId(entity.getAwayTeamId())
                .homeScore(entity.getHomeScore())
                .awayScore(entity.getAwayScore())
                .build();
    }
}
