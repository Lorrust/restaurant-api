package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.PedidoEntity;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PedidoDto {

    private Long id;
    private Long reservaId;
    private String descricao;
    private BigDecimal valor;

    public PedidoDto(PedidoEntity pedido) {
        this.id = pedido.getId();
        this.reservaId = pedido.getReserva().getId();
        this.descricao = pedido.getDescricao();
        this.valor = pedido.getValor();
    }

}
