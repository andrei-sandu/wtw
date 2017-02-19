package utils;

/**
 *
 * Created by andrei-sandu on 19/02/17.
 */
public class LineFormatException extends Throwable {
    public LineFormatException(String reason, int lineNumber) {
        super(reason + " \nat line: " + lineNumber);
    }
}
