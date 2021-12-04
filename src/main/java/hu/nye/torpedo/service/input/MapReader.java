package hu.nye.torpedo.service.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.nye.torpedo.service.exeption.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads map lines from a file.
 */
public class MapReader {

    private static final Logger LOG = LoggerFactory.getLogger(MapReader.class);
    private static final String PATH = "src/main/resources/CpuMap.txt";
    private BufferedReader reader;
    private final List<String> result = new ArrayList<>();

    /**
     * @return String list which contains lines of the cpu map
     * @throws IOException when the file not found
     * @throws FileReadException when IOException occurs
     */
    public List<String> getLinesFromFile() throws IOException, FileReadException {

        try {
            reader = new BufferedReader(new FileReader(PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line.trim());
            }
        } catch (IOException e) {
            LOG.error("CPU map file not found! (" + PATH + ")");
            throw new FileReadException("File not found");

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return result;
    }
}
