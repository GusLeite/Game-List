package br.com.gamelibary.gamelist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    @EmbeddedId
    private BelonginPK id = new BelonginPK();
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList gameList) {
        this.id.setGame(game);
        this.id.setGameList(gameList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Belonging belonging = (Belonging) o;

        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
