package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import youngdev.restaurantapi.dto.RestauranteDto;
import youngdev.restaurantapi.enums.ComidaEnum;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private Integer estrelas;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ComidaEnum tipoComida;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FuncionarioEntity> funcionarios;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<MesaEntity> mesas;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<ClienteEntity> clientes;

    public RestauranteEntity(RestauranteDto restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.cnpj = restaurante.getCnpj();
        this.estrelas = restaurante.getEstrelas();
        this.tipoComida = restaurante.getTipoComida();
    }

    public RestauranteEntity updateRestaurante(RestauranteDto updatedRestaurante) {
        this.nome = updatedRestaurante.getNome();
        this.estrelas = updatedRestaurante.getEstrelas();
        this.tipoComida = updatedRestaurante.getTipoComida();
        return this;
    }
}
