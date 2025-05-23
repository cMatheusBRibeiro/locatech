package br.com.fiap.locatech.repository;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.entities.Veiculo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImp implements PessoaRepository {

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Pessoa> findById(long id) {
        return jdbcClient
                .sql("""
                SELECT
                    *
                FROM
                    pessoas
                WHERE
                    id = :id
                """)
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

    @Override
    public List<Pessoa> findAll(Integer size, Integer offset) {
        return jdbcClient
                .sql("""
                SELECT
                    *
                FROM
                    pessoas
                LIMIT
                    :size
                OFFSET
                    :offset   
                """)
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

    @Override
    public Integer save(Pessoa pessoa) {
        return jdbcClient
                .sql("""
                INSERT INTO pessoas
                    (nome, cpf, email, telefone)
                VALUES
                    (:nome, :cpf, :email, :telefone)
                """)
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("email", pessoa.getEmail())
                .param("telefone", pessoa.getTelefone())
                .update();
    }

    @Override
    public Integer update(Pessoa pessoa, long id) {
        return jdbcClient
                .sql("""
                UPDATE pessoas
                SET
                    nome = :nome,
                    cpf = :cpf,
                    email = :email,
                    telefone = :telefone
                WHERE
                    id = :id
                """)
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("email", pessoa.getEmail())
                .param("telefone", pessoa.getTelefone())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("""
                DELETE FROM pessoas
                WHERE
                    id = :id
                """)
                .param("id", id)
                .update();
    }

}
