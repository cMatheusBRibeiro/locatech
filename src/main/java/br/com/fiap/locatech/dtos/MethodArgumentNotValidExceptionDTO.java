package br.com.fiap.locatech.dtos;

import java.util.List;

public record MethodArgumentNotValidExceptionDTO(
        List<String> errors,
        int status
) {
}
