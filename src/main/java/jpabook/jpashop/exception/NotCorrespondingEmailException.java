package jpabook.jpashop.exception;

public class NotCorrespondingEmailException extends RuntimeException{
    public NotCorrespondingEmailException() {
        super();
    }

    public NotCorrespondingEmailException(String message) {
        super(message);
    }

    public NotCorrespondingEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrespondingEmailException(Throwable cause) {
        super(cause);
    }
}
