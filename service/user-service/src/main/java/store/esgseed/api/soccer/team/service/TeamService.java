package store.esgseed.api.soccer.team.service;

import java.util.List;

import store.esgseed.api.soccer.team.domain.TeamDTO;

public interface TeamService {

    TeamDTO create(TeamDTO dto);

    TeamDTO getById(Long id);

    List<TeamDTO> getAll();

    List<TeamDTO> searchByName(String teamName);

    List<TeamDTO> getByRegion(String regionName);

    TeamDTO update(Long id, TeamDTO dto);

    void delete(Long id);
}

