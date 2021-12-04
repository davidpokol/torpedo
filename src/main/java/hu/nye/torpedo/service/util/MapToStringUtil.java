package hu.nye.torpedo.service.util;

/**
 * Method of this class converts Map to String.
 */
public class MapToStringUtil {

    private final MapUtil mapUtil;

    /**
     *Class constructor.
     */
    public MapToStringUtil(MapUtil mapUtil) {
        this.mapUtil = mapUtil;
    }

    /**
     * Converts a String map into a String.
     */
    public String convertMapToString(String[][] map) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (String string : mapUtil.getRowOfMap(map, i)) {
                builder.append(string);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Converts a boolean map into a String.
     */
    public String convertShipMapToString(boolean[][] shipMap) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < shipMap.length; i++) {
            for (Boolean bool : mapUtil.getRowOfShipMap(shipMap, i)) {
                builder.append(bool ? "1" : "0");

            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
