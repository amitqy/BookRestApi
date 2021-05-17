package com.amit.bookapi.exception;

import com.amit.bookapi.entity.ErrorDetail;
import com.amit.bookapi.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class BookExceptionHandler {
    // Add an exception handler for BookNotFoundException

    /**
     *
     * @param exception that is thrown after an error
     * @return BookErrorResponse exception
     */
    @ExceptionHandler
    public Response<BookErrorResponse> handleException(BookNotFoundException exception){

        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(new ErrorDetail(HttpStatus.NOT_FOUND.value(),exception.getMessage(), LocalDateTime.now().toString()));
        BookErrorResponse error = new BookErrorResponse(errorDetails);

        //return ResponseEntity
        return new Response<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler .... to catch any exception (catch all)

    /**
     *
     * @param exception that is thrown after an error
     * @return BookErrorResponse exception
     */

    @ExceptionHandler
    public Response<BookErrorResponse> handleException(Exception exception){

        // create BookErrorResponse
        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(new ErrorDetail(HttpStatus.BAD_REQUEST.value(),exception.getMessage(), LocalDateTime.now().toString()));
        // create payload for response after exception
        BookErrorResponse error = new BookErrorResponse(errorDetails);
        //return ResponseEntity
        return new Response<>(error, HttpStatus.BAD_REQUEST);
    }

}
