package iti.labs.spring.remoting.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatus();
    public abstract String getMessage();

}
