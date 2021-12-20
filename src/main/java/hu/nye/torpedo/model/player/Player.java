package hu.nye.torpedo.model.player;

import java.util.Objects;

import jakarta.xml.bind.annotation.XmlType;

/**
 * Stores data of a player.
 */
@XmlType(propOrder = {"name", "gamesWon"})
public class Player {

    private String name;
    private int gamesWon;

    public Player(String name, int gamesWon) {
        this.name = name;
        this.gamesWon = gamesWon;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player that = (Player) o;
        return Objects.equals(name, that.name) && Objects.equals(gamesWon, that.gamesWon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gamesWon);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gamesWon=" + gamesWon +
                '}';
    }
}
