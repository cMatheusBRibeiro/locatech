package br.com.fiap.locatech.dtos;

public record ResourceNotFoundExceptionDTO(
        String message,
        int status
) { }
