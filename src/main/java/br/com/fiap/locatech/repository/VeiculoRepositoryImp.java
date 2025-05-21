package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class VeiculoRepositoryImp implements VeiculoRepository {

    private final JdbcClient jdbcClient;

    @Override
    public Optional<Veiculo> findById(long id) {
        return jdbcClient
                .sql("""
                SELECT
                    *
                FROM
                    veiculos
                WHERE
                    id = :id
                """)
                .param("id", id)
                .query(Veiculo.class)
                .optional();
    }

    @Override
    public List<Veiculo> findAll(Integer size, Integer offset) {
        return jdbcClient
                .sql("""
                SELECT
                    *
                FROM
                    veiculos
                LIMIT
                    :size
                OFFSET
                    :offset   
                """)
                .param("size", size)
                .param("offset", offset)
                .query(Veiculo.class)
                .list();
    }

    @Override
    public Integer save(Veiculo veiculo) {
        return jdbcClient
                .sql("""
                INSERT INTO veiculos
                    (marca, modelo, placa, ano, cor, valor_diaria)
                VALUES
                    (:marca, :modelo, :placa, :ano, :cor, :valor_diaria)
                """)
                .param("marca", veiculo.getMarca())
                .param("modelo", veiculo.getModelo())
                .param("placa", veiculo.getPlaca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("valor_diaria", veiculo.getValorDiaria())
                .update();
    }

    @Override
    public Integer update(Veiculo veiculo, long id) {
        return jdbcClient
                .sql("""
                UPDATE veiculos
                SET
                    marca = :marca,
                    modelo = :modelo,
                    placa = :placa,
                    ano = :ano,
                    cor = :cor,
                    valor_diaria = :valor_diaria
                WHERE
                    id = :id
                """)
                .param("marca", veiculo.getMarca())
                .param("modelo", veiculo.getModelo())
                .param("placa", veiculo.getPlaca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("valor_diaria", veiculo.getValorDiaria())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("""
                DELETE FROM veiculos
                WHERE
                    id = :id
                """)
                .param("id", id)
                .update();
    }

}
