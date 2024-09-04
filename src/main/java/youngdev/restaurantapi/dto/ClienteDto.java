package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.ClienteEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDto extends PessoaDto {

    private Long id;
    private Long restaurantId;
    private LocalDate dataCadastro;
    private Integer quantidadeReservas;
    private BigDecimal quantidadeValorGasto;
    private Boolean flgBloqueado;

    public ClienteDto(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.sexo = cliente.getSexo();
        this.telefone = cliente.getTelefone();
        this.restaurantId = cliente.getRestaurante().getId();
        this.dataCadastro = cliente.getDataCadastro();
        this.quantidadeReservas = cliente.getQuantidadeReservas();
        this.quantidadeValorGasto = cliente.getQuantidadeValorGasto();
        this.flgBloqueado = cliente.getFlgBloqueado();
    }

}
