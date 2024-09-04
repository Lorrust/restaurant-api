package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.dto.MesaDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mesa")
public class MesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private Integer capacidadePessoas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity restaurante;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ReservaEntity> reservas;

    public MesaEntity(MesaDto mesa, RestauranteEntity restaurante) {
        this.id = mesa.getId();
        this.restaurante = restaurante;
        this.numero = mesa.getNumero();
        this.capacidadePessoas = mesa.getCapacidadePessoas();
    }

}
