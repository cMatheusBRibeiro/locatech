package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Veiculo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/veiculos")
@Tag(name = "Veículos", description = "Controller de CRUD de veículos")
public interface VeiculoApi {

    @GetMapping
    @Operation(
            description = "Busca de todos os veículos paginado",
            summary = "Busca de veículos",
            responses = {
                    @ApiResponse(description = "Busca bem sucedida", responseCode = "200"),
                    @ApiResponse(description = "Erro interno no servidor", responseCode = "500")
            }
    )
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
