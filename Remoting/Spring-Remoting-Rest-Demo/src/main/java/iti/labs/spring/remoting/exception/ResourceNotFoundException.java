package iti.labs.spring.remoting.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException{
    String message ;
    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message ;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND ;
    }

    @Override
    public String getMessage() {
        return message ;
    }
}
