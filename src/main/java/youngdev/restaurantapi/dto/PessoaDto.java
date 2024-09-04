package youngdev.restaurantapi.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import youngdev.restaurantapi.enums.SexoEnum;

import java.time.LocalDate;

@Getter
@MappedSuperclass
public class PessoaDto {

    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected SexoEnum sexo;
    protected String telefone;

}
