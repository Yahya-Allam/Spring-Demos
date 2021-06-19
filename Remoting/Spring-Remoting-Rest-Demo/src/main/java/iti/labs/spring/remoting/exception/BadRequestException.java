package iti.labs.spring.remoting.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{
    
    private String message ;
    public BadRequestException(String message) {
        super(message);
        this.message = message ;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getMessage() {
        return message ;
    }
}
