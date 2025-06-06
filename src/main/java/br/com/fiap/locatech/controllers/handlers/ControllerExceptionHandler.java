package br.com.fiap.locatech.controllers.handlers;

import br.com.fiap.locatech.dtos.MethodArgumentNotValidExceptionDTO;
import br.com.fiap.locatech.dtos.ResourceNotFoundExceptionDTO;
import br.com.fiap.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundExceptionDTO> handleResourceNotFoundException(
            ResourceNotFoundException resourceNotFoundException
    ) {
        var status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status.value()).body(new ResourceNotFoundExceptionDTO(
                resourceNotFoundException.getMessage(),
                status.value()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException
    ) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = new ArrayList<String>();

        for (var error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        return ResponseEntity.status(status.value()).body(new MethodArgumentNotValidExceptionDTO(
                errors,
                status.value()
        ));
    }

}
