package br.com.fiap.locatech.controllers.handlers;

import br.com.fiap.locatech.dtos.ResourceNotFoundExceptionDTO;
import br.com.fiap.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
