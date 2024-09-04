package youngdev.restaurantapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import youngdev.restaurantapi.dto.ClienteDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity extends PessoaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected LocalDate dataCadastro;
    @Column
    protected Integer quantidadeReservas;
    @Column
    protected BigDecimal quantidadeValorGasto;
    @Column
    protected Boolean flgBloqueado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    protected List<ReservaEntity> reservas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "restaurante_id", nullable = false)
    protected RestauranteEntity restaurante;

    public ClienteEntity(ClienteDto cliente, RestauranteEntity restaurante) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.sexo = cliente.getSexo();
        this.telefone = cliente.getTelefone();
        this.restaurante = restaurante;
        this.dataCadastro = LocalDate.now();
        this.quantidadeReservas = cliente.getQuantidadeReservas();
        this.quantidadeValorGasto = cliente.getQuantidadeValorGasto();
        this.flgBloqueado = cliente.getFlgBloqueado();
    }

    public ClienteEntity updateCliente(ClienteDto updatedCliente) {
        this.telefone = updatedCliente.getTelefone();
        return this;
    }

}
