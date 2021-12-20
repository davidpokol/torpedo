package hu.nye.torpedo.service.exeption;

/**
 * Throws when error occurs while managing a xml file.
 */
public class XmlException extends Exception {
    public XmlException(String message) {
        super(message);
    }
}
