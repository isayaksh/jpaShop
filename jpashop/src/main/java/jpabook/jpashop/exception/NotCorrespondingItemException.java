package jpabook.jpashop.exception;

public class NotCorrespondingItemException extends RuntimeException {

    public NotCorrespondingItemException() {
        super();
    }

    public NotCorrespondingItemException(String message) {
        super(message);
    }

    public NotCorrespondingItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrespondingItemException(Throwable cause) {
        super(cause);
    }

}
