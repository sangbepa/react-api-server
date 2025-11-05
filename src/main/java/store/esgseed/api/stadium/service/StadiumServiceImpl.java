package store.esgseed.api.stadium.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.esgseed.api.stadium.domain.StadiumDTO;
import store.esgseed.api.stadium.domain.Stadium;
import store.esgseed.api.stadium.repository.StadiumRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 경기장 서비스 구현체
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository stadiumRepository;

    @Override
    @Transactional
    public StadiumDTO create(StadiumDTO dto) {
        Stadium entity = Stadium.builder()
                .stadiumName(dto.getStadiumName())
                .hometeamId(dto.getHomeTeamId())
                .seatCount(dto.getSeatCount())
                .address(dto.getAddress())
                .ddd(dto.getDdd())
                .tel(dto.getTel())
                .build();

        Stadium saved = stadiumRepository.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public StadiumDTO getById(Long id) {
        Stadium entity = stadiumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("경기장 데이터를 찾을 수 없습니다. ID: " + id));
        return convertToDTO(entity);
    }

    @Override
    public List<StadiumDTO> getAll() {
        return stadiumRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StadiumDTO> searchByName(String stadiumName) {
        return stadiumRepository.findByStadiumNameContaining(stadiumName).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StadiumDTO> getByHomeTeam(Long homeTeamId) {
        return stadiumRepository.findByHometeamId(homeTeamId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StadiumDTO update(Long id, StadiumDTO dto) {
        Stadium entity = stadiumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("경기장 데이터를 찾을 수 없습니다. ID: " + id));

        entity.setStadiumName(dto.getStadiumName());
        entity.setHometeamId(dto.getHomeTeamId());
        entity.setSeatCount(dto.getSeatCount());
        entity.setAddress(dto.getAddress());
        entity.setDdd(dto.getDdd());
        entity.setTel(dto.getTel());

        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!stadiumRepository.existsById(id)) {
            throw new IllegalArgumentException("경기장 데이터를 찾을 수 없습니다. ID: " + id);
        }
        stadiumRepository.deleteById(id);
    }

    private StadiumDTO convertToDTO(Stadium entity) {
        return StadiumDTO.builder()
                .stadiumId(entity.getId())
                .stadiumName(entity.getStadiumName())
                .homeTeamId(entity.getHometeamId())
                .seatCount(entity.getSeatCount())
                .address(entity.getAddress())
                .ddd(entity.getDdd())
                .tel(entity.getTel())
                .build();
    }
}
