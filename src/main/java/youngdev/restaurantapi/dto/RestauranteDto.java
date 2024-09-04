package youngdev.restaurantapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.enums.ComidaEnum;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RestauranteDto {

    private Long id;
    private String nome;
    private String cnpj;
    private Integer estrelas;
    private ComidaEnum tipoComida;

    public RestauranteDto(RestauranteEntity restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.cnpj = restaurante.getCnpj();
        this.estrelas = restaurante.getEstrelas();
        this.tipoComida = restaurante.getTipoComida();
    }

}
