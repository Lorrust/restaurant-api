package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity extends PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate data_cadastro;
    @Column
    private Integer quantidade_reservas;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ReservaEntity> reservas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

}
