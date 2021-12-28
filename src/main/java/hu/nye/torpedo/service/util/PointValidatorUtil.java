package hu.nye.torpedo.service.util;

import hu.nye.torpedo.model.MapVO;

/** This class validates if a point exists.
 *
 */
public class PointValidatorUtil {


    /** Returns a logical value of a point exist and still untouched.
     *
     * @param c exists on
     * @param mapVO otherwise it is false.
     * @return boolean value
     */
    public boolean isContinue(int[] c, MapVO mapVO) {
        String[][] userMap = mapVO.getMap();
        int size = mapVO.getMapSize();
        return isExistingPoint(c, size) && isUntouchedPoint(userMap[c[0]][c[1]]);
    }

    private boolean isExistingPoint(int[] c, int mapSize) {

        boolean result = false;

        if (c[0] < mapSize && c[1] < mapSize && c[0] >= 0 && c[1] >= 0) {
            result = true;
        } else {
            System.err.println("Invalid input!");
        }
        return result;
    }

    private boolean isUntouchedPoint(String point) {

        boolean result = false;
        if ("0".equals(point)) {
            result = true;
        } else {
            System.err.println("You already shot at this point!");
        }
        return result;
    }
}
