package com.ezypay.subscription.web.rest.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse
{
    public ErrorResponse(HttpStatus status, String message, List<String> details) {
        super();
        this.message = message;
        this.errors = details;
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message) {
        super();
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private HttpStatus status;


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    //General error message about nature of error
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //Specific errors in API request processing
    private List<String> errors;

}