package model;

import java.util.Objects;

public class GameState {

        public static GameStateBuilder builder() {
            return new GameStateBuilder();
        }

        private MapVO currentMap;

        public GameState(MapVO currentMap, boolean shouldExit) {
            this.currentMap = currentMap;
        }

        public MapVO getCurrentMap() {
            return currentMap;
        }

        public void setCurrentMap(MapVO currentMap) {
            this.currentMap = currentMap;
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
            return currentMap.equals(gameState.currentMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentMap);
        }

        @Override
        public String toString() {
            return "State{" +
                    "currentMap=" + currentMap + '}';
        }

    public static final class GameStateBuilder {
        private MapVO currentMap;

        private GameStateBuilder() {
        }
    }
}
