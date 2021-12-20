package hu.nye.torpedo.model;

import java.util.Objects;

/**
 * Stores the data of the current game.
 */
public class GameState {

    private MapVO currentCpuMap;
    private UserMapVO currentUserMap;
    boolean shouldExit;

    public GameState(MapVO currentCpuMap, UserMapVO currentUserMap, boolean shouldExit) {
        this.currentCpuMap = currentCpuMap;
        this.currentUserMap = currentUserMap;
        this.shouldExit = shouldExit;
    }

    public MapVO getCurrentCpuMap() {
        return currentCpuMap;
    }

    public void setCurrentCpuMap(MapVO currentCpuMap) {
        this.currentCpuMap = currentCpuMap;
    }

    public UserMapVO getCurrentUserMap() {
        return currentUserMap;
    }

    public void setCurrentUserMap(UserMapVO currentUserMap) {
        this.currentUserMap = currentUserMap;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameState gameState = (GameState) o;
        return Objects.equals(currentCpuMap, gameState.currentCpuMap) && Objects.equals(currentUserMap, gameState.currentUserMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentCpuMap, currentUserMap);
    }

    @Override
    public String toString() {
        return "GameState{" +
                "currentCpuMap=" + currentCpuMap +
                ", currentUserMap=" + currentUserMap +
                '}';
    }
}

