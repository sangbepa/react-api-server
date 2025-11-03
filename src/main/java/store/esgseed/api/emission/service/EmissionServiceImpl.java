package store.esgseed.api.emission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.esgseed.api.emission.domain.EmissionDTO;
import store.esgseed.api.emission.domain.EmissionEntity;
import store.esgseed.api.emission.repository.EmissionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmissionServiceImpl implements EmissionService {

    private final EmissionRepository emissionRepository;

    @Override
    @Transactional
    public EmissionDTO create(EmissionDTO dto) {
        // DTO -> Entity 변환
        EmissionEntity entity = EmissionEntity.builder()
                .site(dto.getSite())
                .scope1Tco2e(convertToBigDecimal(dto.getScope1Tco2e()))
                .scope2Tco2e(convertToBigDecimal(dto.getScope2Tco2e()))
                .totalScope12Tco2e(convertToBigDecimal(dto.getTotalScope12Tco2e()))
                .scope3Tco2e(convertToBigDecimal(dto.getScope3Tco2e()))
                .build();

        EmissionEntity saved = emissionRepository.save(entity);

        // Entity -> DTO 변환
        return convertToDTO(saved);
    }

    @Override
    public EmissionDTO getById(Long id) {
        EmissionEntity entity = emissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("배출량 데이터를 찾을 수 없습니다. ID: " + id));
        return convertToDTO(entity);
    }

    @Override
    public List<EmissionDTO> getAll() {
        return emissionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmissionDTO> searchBySite(String site) {
        return emissionRepository.findBySiteContaining(site).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmissionDTO update(Long id, EmissionDTO dto) {
        EmissionEntity entity = emissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("배출량 데이터를 찾을 수 없습니다. ID: " + id));

        // DTO -> Entity 업데이트
        entity.setSite(dto.getSite());
        entity.setScope1Tco2e(convertToBigDecimal(dto.getScope1Tco2e()));
        entity.setScope2Tco2e(convertToBigDecimal(dto.getScope2Tco2e()));
        entity.setTotalScope12Tco2e(convertToBigDecimal(dto.getTotalScope12Tco2e()));
        entity.setScope3Tco2e(convertToBigDecimal(dto.getScope3Tco2e()));

        // Entity -> DTO 변환
        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!emissionRepository.existsById(id)) {
            throw new IllegalArgumentException("배출량 데이터를 찾을 수 없습니다. ID: " + id);
        }
        emissionRepository.deleteById(id);
    }

    // Entity -> DTO 변환
    private EmissionDTO convertToDTO(EmissionEntity entity) {
        return EmissionDTO.builder()
                .site(entity.getSite())
                .scope1Tco2e(entity.getScope1Tco2e() != null ? entity.getScope1Tco2e().doubleValue() : null)
                .scope2Tco2e(entity.getScope2Tco2e() != null ? entity.getScope2Tco2e().doubleValue() : null)
                .totalScope12Tco2e(
                        entity.getTotalScope12Tco2e() != null ? entity.getTotalScope12Tco2e().doubleValue() : null)
                .scope3Tco2e(entity.getScope3Tco2e() != null ? entity.getScope3Tco2e().doubleValue() : null)
                .build();
    }

    // Double -> BigDecimal 변환
    private BigDecimal convertToBigDecimal(Double value) {
        return value == null ? BigDecimal.ZERO : BigDecimal.valueOf(value);
    }
}
