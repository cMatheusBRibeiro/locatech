package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository {

    Optional<Veiculo> findById(long id);

    List<Veiculo> findAll(Integer size, Integer offset);

    Integer save(Veiculo veiculo);

    Integer update(Veiculo veiculo, long id);

    Integer delete(Long id);

}
