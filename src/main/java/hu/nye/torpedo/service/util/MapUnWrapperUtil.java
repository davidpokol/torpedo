package hu.nye.torpedo.service.util;

import java.util.List;

/**
 * Converting String values into Map value objects.
 **/
public class MapUnWrapperUtil {

    /**
     * Returns a two-dimensional String array, which converted by a string getting as a parameter.
     **/
    public String[][] convertStringToMap(String string) {

        List<String> rows = List.of(string.split("\n"));
        String[][] result = new String[rows.size()][rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.size(); j++) {

                result[i][j] = String.valueOf(rows.get(i).charAt(j));
            }
        }
        return result;
    }

    /**
     * Returns a two-dimensional boolean array, which converted by a string getting as a parameter.
     **/
    public boolean[][] convertStringToShipMap(String string) {

        List<String> rows = List.of(string.split("\n"));
        boolean[][] result = new boolean[rows.size()][rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.size(); j++) {

                result[i][j] = "1".equals(String.valueOf(rows.get(i).charAt(j)));
            }
        }
        return result;
    }
}
