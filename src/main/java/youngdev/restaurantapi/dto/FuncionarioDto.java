package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.ClienteEntity;
import youngdev.restaurantapi.entity.FuncionarioEntity;
import youngdev.restaurantapi.enums.CargoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FuncionarioDto extends PessoaDto {

    private Long id;
    private Long restauranteId;
    private CargoEnum cargo;
    private LocalDate dataAdmissao;
    private BigDecimal salario;
    private Integer cargaHoraria;

    public FuncionarioDto(FuncionarioEntity funcionario) {
        this.id = funcionario.getId();
        this.restauranteId = funcionario.getRestaurante().getId();
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.cpf = funcionario.getCpf();
        this.dataNascimento = funcionario.getDataNascimento();
        this.sexo = funcionario.getSexo();
        this.telefone = funcionario.getTelefone();
        this.cargo = funcionario.getCargo();
        this.dataAdmissao = funcionario.getDataAdmissao();
        this.salario = funcionario.getSalario();
        this.cargaHoraria = funcionario.getCargaHoraria();
    }

}
