package hu.nye.torpedo.service.exeption;

/**
 * Throws when file not found.
 */
public class FileReadException extends Exception {
    public FileReadException(String message) {
        super(message);
    }
}
