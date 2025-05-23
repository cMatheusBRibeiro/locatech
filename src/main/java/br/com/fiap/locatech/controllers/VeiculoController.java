package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VeiculoController implements VeiculoApi {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            int page,
            int size
    ) {
        logger.info("GET -> /veiculos");
        var veiculos = veiculoService.findAllVeiculos(page, size);
        return ResponseEntity.ok(veiculos);
    }

    public ResponseEntity<Optional<Veiculo>> findVeiculoById(
            Long id
    ) {
        logger.info("GET -> /veiculos/{}", id);
        var veiculo = veiculoService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }

    public ResponseEntity<Void> saveVeiculo(
            Veiculo veiculo
    ) {
        logger.info("POST -> /veiculos");
        veiculoService.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    public ResponseEntity<Void> updateVeiculo(
            Long id,
            Veiculo veiculo
    ) {
        logger.info("PUT -> /veiculos/{}", id);
        veiculoService.update(veiculo, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    public ResponseEntity<Void> deleteVeiculoById(
            Long id
    ) {
        logger.info("DELETE -> /veiculos/{}", id);
        veiculoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
