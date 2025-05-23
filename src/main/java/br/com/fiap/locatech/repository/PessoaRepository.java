package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.entities.Veiculo;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository {

    Optional<Pessoa> findById(long id);

    List<Pessoa> findAll(Integer size, Integer offset);

    Integer save(Pessoa pessoa);

    Integer update(Pessoa pessoa, long id);

    Integer delete(Long id);

}
