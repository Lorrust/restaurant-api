package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.ClienteDto;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.entity.ClienteEntity;
import youngdev.restaurantapi.entity.FuncionarioEntity;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.repository.ClienteRepository;
import youngdev.restaurantapi.repository.FuncionarioRepository;
import youngdev.restaurantapi.service.FuncionarioService;
import youngdev.restaurantapi.service.RestauranteService;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public List<FuncionarioDto> getAllFuncionarios() {
        return repository.findAll().stream().map(FuncionarioDto::new).toList();
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long id) {
        return repository.findById(id).map(FuncionarioDto::new).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<FuncionarioDto> getFuncionariosByRestauranteId(Long restauranteId) {
        return repository.findAllByRestauranteId(restauranteId).stream().map(FuncionarioDto::new).toList();
    }

//    TODO: Fix funcionario creation, not working at the moment
    @Override
    public FuncionarioDto postFuncionario(FuncionarioDto newFuncionario) {
        var restaurante = restauranteService.getRestauranteById(newFuncionario.getRestauranteId());
        var funcionarioEntity = new FuncionarioEntity(newFuncionario, new RestauranteEntity(restaurante));
        var funcionarioPersistido = repository.save(funcionarioEntity);
        return new FuncionarioDto(funcionarioPersistido);
    }

//    TODO: Implement funcionario update
    @Override
    public FuncionarioDto updateFuncionario(Long id, FuncionarioDto updatedFuncionario) {
        return null;
    }

    @Override
    public void deleteFuncionario(Long id) {
        repository.deleteById(id);
    }
}
