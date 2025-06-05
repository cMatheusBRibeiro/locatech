package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.entities.Pessoa;

import java.util.List;
import java.util.Optional;

public interface AluguelRepository {

    Optional<Aluguel> findById(long id);

    List<Aluguel> findAll(Integer size, Integer offset);

    Integer save(Aluguel aluguel);

    Integer update(Aluguel aluguel, long id);

    Integer delete(Long id);

}
