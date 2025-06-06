package br.com.fiap.locatech.entities;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Aluguel {
    private Long id;
    private Long pessoaId;
    private Long veiculoId;
    private String veiculoModelo;
    private String pessoaCpf;
    private String pessoaNome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;

    public Aluguel(AluguelRequestDTO aluguel, BigDecimal valorAluguel) {
        pessoaId = aluguel.pessoaId();
        veiculoId = aluguel.veiculoId();
        dataInicio = aluguel.dataInicio();
        dataFim = aluguel.dataFim();
        valorTotal = valorAluguel;
    }
}
