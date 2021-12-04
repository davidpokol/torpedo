package hu.nye.torpedo.service.util;

/**
 * This class helps to reference a point of a map.
 */
public class ShipReferenceUtil {

    /**
     *Formats an option to into an integer array.
     *For example if the input is 15, the @return will be A1.
     */
    public int[] formatOption(String rawOption) {

        int[] result = {-1, -1};
        try {
            char row = rawOption.toUpperCase().charAt(0);
            int column = Integer.parseInt(rawOption.substring(1));

            if (isValidColumnNumber(row) && isValidRowNumber(column)) {
                result[0] = (row - 65);
                result[1] = column - 1;

            }
        } catch (Exception ignored) { }

        return result;
    }

    private boolean isValidColumnNumber(char row) {
        return row >= 'A' && row <= 'I';

    }

    private boolean isValidRowNumber(int column) {
        return column >= 1 && column <= 9;

    }
}

