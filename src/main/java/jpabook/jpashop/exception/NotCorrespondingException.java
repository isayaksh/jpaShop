package jpabook.jpashop.exception;

public class NotCorrespondingException extends RuntimeException {
    public NotCorrespondingException() {
        super();
    }

    public NotCorrespondingException(String message) {
        super(message);
    }

    public NotCorrespondingException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrespondingException(Throwable cause) {
        super(cause);
    }
}
