package store.esgseed.api.emission.service;

import store.esgseed.api.emission.domain.EmissionDTO;

import java.util.List;

public interface EmissionService {

    EmissionDTO create(EmissionDTO dto);

    EmissionDTO getById(Long id);

    List<EmissionDTO> getAll();

    List<EmissionDTO> searchBySite(String site);

    EmissionDTO update(Long id, EmissionDTO dto);

    void delete(Long id);
}
