package youngdev.restaurantapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import youngdev.restaurantapi.dto.MesaDto;

import java.time.LocalDate;

public interface MesaRepositoryCustom {
    Page<MesaDto> getMesasDisponiveis(Pageable pageable, Long restauranteId, Integer quantidadePessoas, LocalDate data);
}
