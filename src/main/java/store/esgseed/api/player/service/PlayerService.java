package store.esgseed.api.player.service;

import store.esgseed.api.player.domain.PlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO create(PlayerDTO dto);

    PlayerDTO getById(Long id);

    List<PlayerDTO> getAll();

    List<PlayerDTO> searchByName(String playerName);

    List<PlayerDTO> getByPosition(String position);

    PlayerDTO update(Long id, PlayerDTO dto);

    void delete(Long id);
}

