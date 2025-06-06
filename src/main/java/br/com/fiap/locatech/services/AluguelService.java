package br.com.fiap.locatech.services;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.repository.AluguelRepository;
import br.com.fiap.locatech.repository.VeiculoRepository;
import br.com.fiap.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final VeiculoRepository veiculoRepository;

    public AluguelService(AluguelRepository aluguelRepository, VeiculoRepository veiculoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public Aluguel findAluguelById(Long id) {
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado"));
    }

    public List<Aluguel> findAllAlugueis(int page, int size) {
        int offset = (page - 1) * size;
        return aluguelRepository.findAll(size, offset);
    }

    public void save(AluguelRequestDTO aluguel) {
        var valorAluguel = calcularAluguel(aluguel);
        var aluguelEntity = new Aluguel(aluguel, valorAluguel);

        var save = aluguelRepository.save(aluguelEntity);

        Assert.state(save == 1, "Erro ao salvar o aluguel " + aluguel.pessoaId());
    }

    public void update(AluguelRequestDTO aluguel, Long id) {
        var valorAluguel = calcularAluguel(aluguel);
        var aluguelEntity = new Aluguel(aluguel, valorAluguel);

        var update = aluguelRepository.update(aluguelEntity, id);

        if (update == 0) {
            throw new ResourceNotFoundException("Aluguel não encontrado");
        }
    }

    public void delete(Long id) {
        var delete = aluguelRepository.delete(id);
        if (delete == 0) {
            throw new ResourceNotFoundException("Aluguel não encontrada");
        }
    }

    private BigDecimal calcularAluguel(AluguelRequestDTO aluguel) {
        var veiculo = veiculoRepository.findById(aluguel.veiculoId())
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado"));
        var quantidadeDias = BigDecimal.valueOf(aluguel.dataFim().getDayOfYear() - aluguel.dataInicio().getDayOfYear());

        var valorAluguel = quantidadeDias.multiply(veiculo.getValorDiaria());

        return valorAluguel;
    }
}
