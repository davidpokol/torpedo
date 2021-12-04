package hu.nye.torpedo.service.util;

import java.util.List;

/**
 *
 */
public class FileManagerUtil {

    /**
     * @return two-dimensional array converted by a String list.
     */
    public boolean[][] getPreparedMap(List<String> lines) {

        int size = lines.size();
        boolean[][] result = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = lines.get(i).split("");
            for (int j = 0; j < size; j++) {
                result[i][j] = line[j].equals("1");
            }
        }
        return result;
    }
}
