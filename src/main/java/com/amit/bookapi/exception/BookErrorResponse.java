package com.amit.bookapi.exception;

import com.amit.bookapi.entity.ErrorDetail;

import java.util.List;

public class BookErrorResponse {


    private List<ErrorDetail> errorDetails;

    public  BookErrorResponse(){

    }
    public BookErrorResponse(List<ErrorDetail> errorDetails){
        this.errorDetails = errorDetails;
    }

    public List<ErrorDetail> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<ErrorDetail> errorDetails) {
        this.errorDetails = errorDetails;
    }

}
