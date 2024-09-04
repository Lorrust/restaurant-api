package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.dto.PedidoDto;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "reserva_id", nullable = false)
    private ReservaEntity reserva;

    public PedidoEntity(PedidoDto pedido, ReservaEntity reserva) {
        this.id = pedido.getId();
        this.reserva = reserva;
        this.descricao = pedido.getDescricao();
        this.valor = pedido.getValor();
    }

}
