package com.example.application.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.application.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex)
	{
        String errorMessage = ex.getBindingResult()
                                .getAllErrors()
                                .get(0)
                                .getDefaultMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(CustomeException.class)
	public ResponseEntity<ApiResponse<String>> handleNoEmployeeFoundException(CustomeException e)
	{
		ApiResponse<String> apiResponse=new ApiResponse<String>(e.getMessage());
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
