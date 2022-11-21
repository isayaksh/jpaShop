package jpabook.jpashop.exception;

public class NotCorrespondingOrderException extends RuntimeException{
    public NotCorrespondingOrderException() {
        super();
    }

    public NotCorrespondingOrderException(String message) {
        super(message);
    }

    public NotCorrespondingOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrespondingOrderException(Throwable cause) {
        super(cause);
    }
}
