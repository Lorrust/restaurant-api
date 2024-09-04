package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.ReservaEntity;
import youngdev.restaurantapi.enums.StatusEnum;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservaDto {

    private Long id;
    private Long clienteId;
    private Long mesaId;
    private LocalDate dataReserva;
    private Integer quantidadePessoas;
    private StatusEnum status;
    private String observacao;

    public ReservaDto(ReservaEntity reserva) {
        this.id = reserva.getId();
        this.clienteId = reserva.getCliente().getId();
        this.mesaId = reserva.getMesa().getId();
        this.dataReserva = reserva.getDataReserva();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.status = reserva.getStatus();
        this.observacao = reserva.getObservacao();
    }
}
