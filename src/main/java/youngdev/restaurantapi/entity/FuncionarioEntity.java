package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.enums.CargoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "funcionario")
public class FuncionarioEntity extends PessoaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private CargoEnum cargo;
    @Column(nullable = false)
    private LocalDate dataAdmissao;
    @Column(nullable = false)
    private BigDecimal salario;
    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    public FuncionarioEntity(FuncionarioDto funcionario, RestauranteEntity restaurante) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.cpf = funcionario.getCpf();
        this.dataNascimento = funcionario.getDataNascimento();
        this.sexo = funcionario.getSexo();
        this.telefone = funcionario.getTelefone();
        this.restaurante = restaurante;
        this.cargo = funcionario.getCargo();
        this.dataAdmissao = funcionario.getDataAdmissao();
        this.salario = funcionario.getSalario();
        this.cargaHoraria = funcionario.getCargaHoraria();
    }

}

