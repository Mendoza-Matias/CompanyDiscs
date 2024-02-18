package com.record.company.com.presentation.controller.advice;

import com.record.company.com.domain.dto.exception.ExceptionDto;
import com.record.company.com.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseBody
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(notFoundException.getMessage()));
    }
}
