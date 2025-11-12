package store.esgseed.api.soccer.stadium.service;

import java.util.List;

import store.esgseed.api.soccer.stadium.domain.StadiumDTO;

public interface StadiumService {

    StadiumDTO create(StadiumDTO dto);

    StadiumDTO getById(Long id);

    List<StadiumDTO> getAll();

    List<StadiumDTO> searchByName(String stadiumName);

    List<StadiumDTO> getByHomeTeam(String homeTeamUk);

    StadiumDTO update(Long id, StadiumDTO dto);

    void delete(Long id);
}

