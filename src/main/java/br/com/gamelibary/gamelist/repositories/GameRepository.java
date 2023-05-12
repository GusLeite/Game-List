package br.com.gamelibary.gamelist.repositories;

import br.com.gamelibary.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
