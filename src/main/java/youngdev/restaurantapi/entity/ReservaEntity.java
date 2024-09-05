package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.dto.ReservaDto;
import youngdev.restaurantapi.enums.StatusEnum;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataReserva;
    @Column(nullable = false)
    private Integer quantidadePessoas;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StatusEnum status;
    @Column
    private Integer avaliacao;
    @Column
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "mesa_id", nullable = false)
    private MesaEntity mesa;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<PedidoEntity> pedidos;

    public ReservaEntity(ReservaDto reserva, ClienteEntity cliente, MesaEntity mesa) {
        this.id = reserva.getId();
        this.cliente = cliente;
        this.mesa = mesa;
        this.dataReserva = reserva.getDataReserva();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.status = StatusEnum.AGENDADA;
        this.observacao = reserva.getObservacao();
    }

    public void updateReserva(ReservaDto updatedReserva) {
        this.dataReserva = updatedReserva.getDataReserva();
    }
}
