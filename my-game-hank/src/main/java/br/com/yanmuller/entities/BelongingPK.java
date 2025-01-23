package br.com.yanmuller.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK() {}

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        BelongingPK that = (BelongingPK) o;
        return Objects.equals(getGame(), that.getGame()) && Objects.equals(getGameList(), that.getGameList());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getGame());
        result = 31 * result + Objects.hashCode(getGameList());
        return result;
    }
}
