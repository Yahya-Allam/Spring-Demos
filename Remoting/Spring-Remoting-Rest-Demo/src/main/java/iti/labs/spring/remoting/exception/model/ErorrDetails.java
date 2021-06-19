package iti.labs.spring.remoting.exception.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ErorrDetails {
    @NonNull
    String message ;
    @NonNull
    String uri ;
    @NonNull
    String  time ;

    @NonNull
    String  code;

    @NonNull
    String  error;


}
