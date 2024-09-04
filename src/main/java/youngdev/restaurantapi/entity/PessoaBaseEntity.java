package youngdev.restaurantapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import youngdev.restaurantapi.enums.SexoEnum;

import java.time.LocalDate;

@Getter
@MappedSuperclass
public class PessoaBaseEntity {

    @Column(nullable = false)
    protected String nome;
    @Column(nullable = false)
    protected String sobrenome;
    @Column(unique = true)
    protected String cpf;
    @Column(nullable = false)
    protected LocalDate dataNascimento;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    protected SexoEnum sexo;
    @Column(unique = true)
    protected String telefone;

}
