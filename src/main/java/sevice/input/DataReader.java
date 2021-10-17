package sevice.input;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataReader {

    private static final Logger LOG = LoggerFactory.getLogger(DataReader.class);
    private final BufferedReader reader;

    public DataReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String readInput() {
        String input = null;

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOG.error("Exception occurred while reading user input", e);
        }

        return input;
    }
}
