package youngdev.restaurantapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.entity.FuncionarioEntity;

import java.util.List;

public interface FuncionarioService {

    List<FuncionarioDto> getAllFuncionarios();

    FuncionarioDto getFuncionarioById(Long id);

    List<FuncionarioDto> getFuncionariosByRestauranteId(Long restauranteId);

    FuncionarioDto postFuncionario(FuncionarioDto newFuncionario);

    FuncionarioDto updateFuncionario(Long id, FuncionarioDto updatedFuncionario);

    void deleteFuncionario(Long id);
    
}
