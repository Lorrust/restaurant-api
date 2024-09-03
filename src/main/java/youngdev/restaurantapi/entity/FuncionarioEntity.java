package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.enums.CargoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class FuncionarioEntity extends PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private CargoEnum cargo;
    @Column(nullable = false)
    private LocalDate data_admissao;
    @Column(nullable = false)
    private BigDecimal salario;
    @Column(nullable = false)
    private Integer carga_horaria;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

}

