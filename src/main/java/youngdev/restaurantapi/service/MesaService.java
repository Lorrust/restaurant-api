package youngdev.restaurantapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.entity.MesaEntity;

import java.time.LocalDate;
import java.util.List;

public interface MesaService {

    List<MesaDto> getAllMesas();

    Page<MesaDto> getMesasDisponiveis(Pageable pageable, Long restauranteId, Integer numPessoas, LocalDate data);

    MesaDto getMesaById(Long id);

    MesaEntity getMesaEntityById(Long id);

    List<MesaDto> getMesasByRestauranteId(Long restauranteId);

    MesaDto postMesa(MesaDto newMesa);

    MesaDto updateMesa(Long id, MesaDto updatedMesa);

    void deleteMesa(Long id);

}
