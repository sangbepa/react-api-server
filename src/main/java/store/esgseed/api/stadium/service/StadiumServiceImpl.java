package store.esgseed.api.stadium.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.esgseed.api.stadium.domain.StadiumDTO;
import store.esgseed.api.stadium.domain.StadiumEntity;
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
        StadiumEntity entity = StadiumEntity.builder()
                .stadiumName(dto.getStadiumName())
                .homeTeamId(dto.getHomeTeamId())
                .seatCount(dto.getSeatCount())
                .address(dto.getAddress())
                .ddd(dto.getDdd())
                .tel(dto.getTel())
                .build();

        StadiumEntity saved = stadiumRepository.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public StadiumDTO getById(Long id) {
        StadiumEntity entity = stadiumRepository.findById(id)
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
        return stadiumRepository.findByHomeTeamId(homeTeamId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StadiumDTO update(Long id, StadiumDTO dto) {
        StadiumEntity entity = stadiumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("경기장 데이터를 찾을 수 없습니다. ID: " + id));

        entity.setStadiumName(dto.getStadiumName());
        entity.setHomeTeamId(dto.getHomeTeamId());
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

    private StadiumDTO convertToDTO(StadiumEntity entity) {
        return StadiumDTO.builder()
                .stadiumId(entity.getStadiumId())
                .stadiumName(entity.getStadiumName())
                .homeTeamId(entity.getHomeTeamId())
                .seatCount(entity.getSeatCount())
                .address(entity.getAddress())
                .ddd(entity.getDdd())
                .tel(entity.getTel())
                .build();
    }
}
