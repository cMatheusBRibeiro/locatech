package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.services.PessoaService;
import br.com.fiap.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController implements PessoaApi {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public ResponseEntity<List<Pessoa>> findAllPessoas(
            int page,
            int size
    ) {
        logger.info("GET -> /pessoas");
        var pessoas = pessoaService.findAllPessoas(page, size);
        return ResponseEntity.ok(pessoas);
    }

    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            Long id
    ) {
        logger.info("GET -> /pessoas/{}", id);
        var pessoa = pessoaService.findPessoaById(id);
        return ResponseEntity.ok(pessoa);
    }

    public ResponseEntity<Void> savePessoa(
            Pessoa pessoa
    ) {
        logger.info("POST -> /pessoas");
        pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    public ResponseEntity<Void> updatePessoa(
            Long id,
            Pessoa pessoa
    ) {
        logger.info("PUT -> /pessoas/{}", id);
        pessoaService.update(pessoa, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    public ResponseEntity<Void> deletePessoaById(
            Long id
    ) {
        logger.info("DELETE -> /pessoas/{}", id);
        pessoaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
