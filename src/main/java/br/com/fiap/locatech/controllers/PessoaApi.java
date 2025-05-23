package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.entities.Veiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pessoas")
public interface PessoaApi {

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            @PathVariable("id") Long id
    );

    @PostMapping
    public ResponseEntity<Void> savePessoa(
            @RequestBody Pessoa pessoa
    );

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable Long id,
            @RequestBody Pessoa pessoa
    );

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoaById(
            @PathVariable Long id
    );

}
