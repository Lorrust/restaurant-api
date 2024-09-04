package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.MesaEntity;
import youngdev.restaurantapi.entity.ReservaEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MesaDto {

    private Long id;
    private Long restauranteId;
    private Integer numero;
    private Integer capacidadePessoas;

    public MesaDto(MesaEntity mesa) {
        this.id = mesa.getId();
        this.restauranteId = mesa.getRestaurante().getId();
        this.numero = mesa.getNumero();
        this.capacidadePessoas = mesa.getCapacidadePessoas();
    }

}
