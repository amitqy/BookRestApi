package com.amit.bookapi.entity;


import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response<T> implements Serializable {
    private T entity;

    private int status;

    // list of error details objects -> error code + error message
    private List<ErrorDetail> errorDetails = new ArrayList<>();

    public Response(T entity,List<ErrorDetail> errorDetails) {
        this.entity = entity;
        this.errorDetails = errorDetails;
    }

    public Response(T entity,int status) {
        this.entity = entity;
        this.status = status;
    }

    public Response(List<ErrorDetail> errorDetails){
        this.errorDetails = errorDetails;
    }

    public Response(T error, HttpStatus badRequest) {
        this.status = badRequest.value();
        this.entity = error;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
    public List<ErrorDetail> getErrorDetails() {
        return errorDetails;
    }

    public void setErrors(List<ErrorDetail> errorDetails) {

        this.errorDetails = errorDetails;
    }

    public int getStatus() {
        return status;
    }
}
