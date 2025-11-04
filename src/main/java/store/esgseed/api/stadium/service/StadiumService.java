package store.esgseed.api.stadium.service;

import store.esgseed.api.stadium.domain.StadiumDTO;

import java.util.List;

public interface StadiumService {

    StadiumDTO create(StadiumDTO dto);

    StadiumDTO getById(Long id);

    List<StadiumDTO> getAll();

    List<StadiumDTO> searchByName(String stadiumName);

    List<StadiumDTO> getByHomeTeam(Long homeTeamId);

    StadiumDTO update(Long id, StadiumDTO dto);

    void delete(Long id);
}

