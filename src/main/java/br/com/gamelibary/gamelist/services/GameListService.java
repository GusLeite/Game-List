package br.com.gamelibary.gamelist.services;

import br.com.gamelibary.gamelist.dto.GameListDTO;
import br.com.gamelibary.gamelist.entities.GameList;
import br.com.gamelibary.gamelist.projection.GameMinProjection;
import br.com.gamelibary.gamelist.repositories.GameListRepository;
import br.com.gamelibary.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection remove = list.remove(sourceIndex);
        list.add(destinationIndex,remove);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i<=max;i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }



}
