package com.companyDiscs.presentation.advice;
import com.companyDiscs.domain.dto.generic.ExceptionErrorDto;
import com.companyDiscs.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.FORBIDDEN.value()));
    }

    @ExceptionHandler(value = {UserException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleUserException(UserException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(value = {ClientException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleClientException(ClientException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(value = {ArtistException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleArtistException(ArtistException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(value = {AlbumImageException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleAlbumImageException (AlbumImageException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(value = {AlbumException.class})
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleAlbumException (AlbumException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage(),HttpStatus.CONFLICT.value()));
    }
}
