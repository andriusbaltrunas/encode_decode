package coding;

/**
 * Created by andriusbaltrunas on 3/26/2018.
 */
public class JACodeException extends Exception {

    public JACodeException() {
        super();
    }

    public JACodeException(String message) {
        super(message);
    }

    public JACodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JACodeException(Throwable cause) {
        super(cause);
    }
}
