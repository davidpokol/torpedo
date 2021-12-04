package hu.nye.torpedo.service.input;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads data from console.
 */
public class DataReader {

    private static final Logger LOG = LoggerFactory.getLogger(DataReader.class);
    private final BufferedReader reader;

    /**
     *Class constructor.
     */
    public DataReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     *Reads input from the console.
     */
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
