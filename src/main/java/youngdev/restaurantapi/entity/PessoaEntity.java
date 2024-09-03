package youngdev.restaurantapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import youngdev.restaurantapi.enums.SexoEnum;

import java.time.LocalDate;

@MappedSuperclass
public class PessoaEntity {

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(nullable = false)
    private LocalDate data_nascimento;
    @Column(nullable = false)
    private SexoEnum sexo;
    @Column(unique = true)
    private String telefone;

}
