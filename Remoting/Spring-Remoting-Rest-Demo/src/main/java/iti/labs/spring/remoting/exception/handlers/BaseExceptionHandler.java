package iti.labs.spring.remoting.exception.handlers;

import iti.labs.spring.remoting.exception.BaseException;
import iti.labs.spring.remoting.exception.model.ErorrDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErorrDetails> handleApiException(BaseException ex, WebRequest request) {
        ErorrDetails erorrDetails =
                buildErrorDetails(ex.getMessage(), request.getDescription(false), ex.getStatus());
        return new ResponseEntity<>(erorrDetails, ex.getStatus());
    }

    private ErorrDetails buildErrorDetails(String message, String description, HttpStatus status) {
        ErorrDetails erorr = new ErorrDetails();
        erorr . setCode(status.value()+"");
        erorr . setMessage(message);
        erorr . setTime(LocalDateTime.now().toString());
        erorr . setUri(description);
        erorr . setError(status.getReasonPhrase());
        return erorr;
    }


}
