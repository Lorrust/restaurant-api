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
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(nullable = false)
    private LocalDate data_nascimento;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private SexoEnum sexo;
    @Column(unique = true)
    private String telefone;

}
