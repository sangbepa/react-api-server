package store.esgseed.api.team.service;

import store.esgseed.api.team.domain.TeamDTO;

import java.util.List;

public interface TeamService {

    TeamDTO create(TeamDTO dto);

    TeamDTO getById(Long id);

    List<TeamDTO> getAll();

    List<TeamDTO> searchByName(String teamName);

    List<TeamDTO> getByRegion(String regionName);

    TeamDTO update(Long id, TeamDTO dto);

    void delete(Long id);
}

