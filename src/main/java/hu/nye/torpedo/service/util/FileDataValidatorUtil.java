package hu.nye.torpedo.service.util;

import java.util.List;

import hu.nye.torpedo.service.exeption.FileDataException;

/**
 * This class validates the CPU's map.
 */
public class FileDataValidatorUtil {

    private static final String PATTERN = "^[01]+$";

    /** Returns a boolean value depends on the cpu's map validity.
     *
     * @throws FileDataException when the Cpu's, which was ridden from the resources folder, is not valid
     */
    public boolean isValidMap(List<String> mapLines) throws FileDataException {

        if (mapLines.size() < 4  || mapLines.size() > 9) {
            throw new FileDataException("The CPU's map must be between 4 and 9");
        } else if (!isSquared(mapLines)) {
            throw new FileDataException("The CPU's map must be squared!");
        } else if (!isFilledUpWithProperValues(mapLines)) {
            throw new FileDataException("The CPU's map must be filled up with only 0 and 1 values!");
        } else if (!isProperNumberOfShips(mapLines)) {
            throw new FileDataException("The CPU's map must has proper number of ships!");
        }
        return true;
    }

    private boolean isSquared(List<String> mapLines) {

        boolean result = true;
        int columns = mapLines.size();
        for (String item : mapLines) {
            if (item.length() != columns) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isFilledUpWithProperValues(List<String> mapLines) {

        boolean result = true;
        for (String item : mapLines) {
            if (!item.matches(PATTERN)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isProperNumberOfShips(List<String> mapLines) {

        int expectedNumber = sum(mapLines.size() - 1);
        int checkedFields = 0;
        for (String item : mapLines) {
            checkedFields += item.chars().filter(ch -> ch == '1').count();
        }
        return  expectedNumber == checkedFields;
    }

    /** Until a number, this method sums every single number.
     *
     * @return the sum.
     */
    public int sum(int bound) {
        int result = 0;
        for (int i = 1; i <= bound; i++) {
            result += i;
        }
        return result;
    }
}
