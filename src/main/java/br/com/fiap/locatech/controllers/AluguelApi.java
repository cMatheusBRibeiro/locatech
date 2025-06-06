package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/alugueis")
public interface AluguelApi {

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findAluguelById(
            @PathVariable("id") Long id
    );

    @PostMapping
    public ResponseEntity<Void> saveAluguel(
            @RequestBody AluguelRequestDTO aluguel
    );

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(
            @PathVariable Long id,
            @RequestBody AluguelRequestDTO aluguel
    );

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguelById(
            @PathVariable Long id
    );

}
