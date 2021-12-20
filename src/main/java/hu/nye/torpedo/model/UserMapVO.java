package hu.nye.torpedo.model;

import java.util.Objects;

/**
 * Stores the current USER'S data.
 */
public class UserMapVO extends MapVO {

    private final String userName;

    public UserMapVO(String[][] map, boolean[][] reservedPoints, String userName) {
        super(map, reservedPoints);
        this.userName = userName;
    }

    public String getUserName() {
        return copy(userName);
    }

    private String copy(String string) {
        String copy = string;
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserMapVO userMapVO = (UserMapVO) o;
        return Objects.deepEquals(userName, userMapVO.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "UserMapVO{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
