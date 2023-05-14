package br.com.gamelibary.gamelist.services;

import br.com.gamelibary.gamelist.dto.GameListDTO;
import br.com.gamelibary.gamelist.entities.GameList;
import br.com.gamelibary.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }



}
