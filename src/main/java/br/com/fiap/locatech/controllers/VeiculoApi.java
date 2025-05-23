package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/veiculos")
public interface VeiculoApi {

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculoById(
            @PathVariable("id") Long id
    );

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(
            @RequestBody Veiculo veiculo
    );

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(
            @PathVariable Long id,
            @RequestBody Veiculo veiculo
    );

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculoById(
            @PathVariable Long id
    );

}
