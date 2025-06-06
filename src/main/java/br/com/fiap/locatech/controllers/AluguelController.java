package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.services.AluguelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AluguelController implements AluguelApi {

    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            int page,
            int size
    ) {
        logger.info("GET -> /alugueis");
        var alugueis = aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(alugueis);
    }

    public ResponseEntity<Aluguel> findAluguelById(
            Long id
    ) {
        logger.info("GET -> /alugueis/{}", id);

        var aluguel = aluguelService.findAluguelById(id);

        return ResponseEntity.ok(aluguel);
    }

    public ResponseEntity<Void> saveAluguel(
            AluguelRequestDTO aluguel
    ) {
        logger.info("POST -> /alugueis");
        aluguelService.save(aluguel);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    public ResponseEntity<Void> updateAluguel(
            Long id,
            AluguelRequestDTO aluguel
    ) {
        logger.info("PUT -> /alugueis/{}", id);
        aluguelService.update(aluguel, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    public ResponseEntity<Void> deleteAluguelById(
            Long id
    ) {
        logger.info("DELETE -> /alugueis/{}", id);
        aluguelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
