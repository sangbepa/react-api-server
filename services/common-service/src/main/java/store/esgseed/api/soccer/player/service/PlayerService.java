package store.esgseed.api.soccer.player.service;

import java.util.List;

import store.esgseed.api.soccer.player.domain.PlayerDTO;

public interface PlayerService {

    PlayerDTO create(PlayerDTO dto);

    PlayerDTO getById(Long id);

    List<PlayerDTO> getAll();

    List<PlayerDTO> searchByName(String playerName);

    List<PlayerDTO> getByPosition(String position);

    PlayerDTO update(Long id, PlayerDTO dto);

    void delete(Long id);
}

