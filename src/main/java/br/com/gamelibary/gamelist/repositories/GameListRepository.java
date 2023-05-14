package br.com.gamelibary.gamelist.repositories;

import br.com.gamelibary.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
