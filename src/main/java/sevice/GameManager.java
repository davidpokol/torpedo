package sevice;

import sevice.exeption.OptionReadException;

public class GameManager {

    public String formatOption(String rawOption) throws OptionReadException {

        char row = rawOption.toUpperCase().charAt(0);
        int column = Integer.parseInt(rawOption.substring(1, 2));
        String result = null;
        if (isContinue(row) && isContinue(column)) {
            result = String.valueOf(row - 65) + (int) column;

        } else {
            throw new OptionReadException("Invalid input!");
        }

        return result;
    }

    private boolean isContinue(char row) {
        return row >= 'A' && row <= 'I';

    }

    private boolean isContinue(int column) {
        return column >= 0 && column <= 8;

    }
}

