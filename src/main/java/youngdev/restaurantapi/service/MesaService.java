package youngdev.restaurantapi.service;

import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.entity.MesaEntity;

import java.util.List;

public interface MesaService {

    List<MesaDto> getAllMesas();

    MesaDto getMesaById(Long id);

    MesaEntity getMesaEntityById(Long id);

    List<MesaDto> getMesasByRestauranteId(Long restauranteId);

    MesaDto postMesa(MesaDto newMesa);

    MesaDto updateMesa(Long id, MesaDto updatedMesa);

    void deleteMesa(Long id);

}
