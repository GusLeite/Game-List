package br.com.gamelibary.gamelist.services;

import br.com.gamelibary.gamelist.dto.GameDTO;
import br.com.gamelibary.gamelist.dto.GameMinDTO;
import br.com.gamelibary.gamelist.entities.Game;
import br.com.gamelibary.gamelist.projection.GameMinProjection;
import br.com.gamelibary.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game result = gameRepository.findById(gameId).get();
        return new GameDTO(result);

    }
        @Transactional(readOnly = true)
        public List<GameMinDTO> findAll() {
            List<Game> result = gameRepository.findAll();
            return result.stream().map(GameMinDTO::new).toList();
        }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }


    }

