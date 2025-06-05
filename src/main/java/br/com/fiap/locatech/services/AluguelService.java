package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repository.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Optional<Aluguel> findAluguelById(Long id) {
        return aluguelRepository.findById(id);
    }

    public List<Aluguel> findAllAlugueis(int page, int size) {
        int offset = (page - 1) * size;
        return aluguelRepository.findAll(size, offset);
    }

    public void save(Aluguel aluguel) {
        var save = aluguelRepository.save(aluguel);
        Assert.state(save == 1, "Erro ao salvar o aluguel " + aluguel.getPessoaId());
    }

    public void update(Aluguel aluguel, Long id) {
        var update = aluguelRepository.update(aluguel, id);
        if (update == 0) {
            throw new RuntimeException("Aluguel não encontrada");
        }
    }

    public void delete(Long id) {
        var delete = aluguelRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Aluguel não encontrada");
        }
    }

}
