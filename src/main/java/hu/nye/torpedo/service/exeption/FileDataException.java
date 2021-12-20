package hu.nye.torpedo.service.exeption;

/**
 * Throws when there is a problem with the CpuMap.txt.
 */
public class FileDataException extends Exception {
    public FileDataException(String message) {
        super(message);
    }
}
