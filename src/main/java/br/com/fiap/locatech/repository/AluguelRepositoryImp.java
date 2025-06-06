package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Aluguel;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AluguelRepositoryImp implements AluguelRepository {

    private final JdbcClient jdbcClient;

    public AluguelRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Aluguel> findById(long id) {
        return jdbcClient
                .sql("""
                SELECT
                    a.id AS id,
                    a.pessoa_id AS pessoa_id,
                    a.veiculo_id AS veiculo_id,
                    v.modelo AS veiculo_modelo,
                    p.cpf AS pessoa_cpf,
                    p.nome AS pessoa_nome,
                    a.data_inicio AS data_inicio,
                    a.data_fim AS data_fim,
                    a.valor_total AS valor_total
                FROM
                    alugueis a
                INNER JOIN
                    pessoas p
                    ON a.pessoa_id = p.id
                INNER JOIN
                    veiculos v
                    ON a.veiculo_id = v.id
                WHERE
                    a.id = :id
                """)
                .param("id", id)
                .query(Aluguel.class)
                .optional();
    }

    @Override
    public List<Aluguel> findAll(Integer size, Integer offset) {
        return jdbcClient
                .sql("""
                SELECT
                    a.id AS id,
                    a.pessoa_id AS pessoa_id,
                    a.veiculo_id AS veiculo_id,
                    v.modelo AS veiculo_modelo,
                    p.cpf AS pessoa_cpf,
                    p.nome AS pessoa_nome,
                    a.data_inicio AS data_inicio,
                    a.data_fim AS data_fim,
                    a.valor_total AS valor_total
                FROM
                    alugueis a
                INNER JOIN
                    pessoas p
                    ON a.pessoa_id = p.id
                INNER JOIN
                    veiculos v
                    ON a.veiculo_id = v.id
                LIMIT
                    :size
                OFFSET
                    :offset
                """)
                .param("size", size)
                .param("offset", offset)
                .query(Aluguel.class)
                .list();
    }

    @Override
    public Integer save(Aluguel aluguel) {
        return jdbcClient
                .sql("""
                INSERT INTO alugueis
                    (pessoa_id, veiculo_id, data_inicio, data_fim, valor_total)
                VALUES
                    (:pessoaId, :veiculoId, :dataInicio, :dataFim, :valorTotal)
                """)
                .param("pessoaId", aluguel.getPessoaId())
                .param("veiculoId", aluguel.getVeiculoId())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .update();
    }

    @Override
    public Integer update(Aluguel aluguel, long id) {
        return jdbcClient
                .sql("""
                UPDATE alugueis
                SET
                    pessoa_id = :pessoaId,
                    veiculo_id = :veiculoId,
                    data_inicio = :dataInicio,
                    data_fim = :dataFim,
                    valor_total = :valorTotal
                WHERE
                    id = :id
                """)
                .param("pessoaId", aluguel.getPessoaId())
                .param("veiculoId", aluguel.getVeiculoId())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("""
                DELETE FROM alugueis
                WHERE
                    id = :id
                """)
                .param("id", id)
                .update();
    }

}
