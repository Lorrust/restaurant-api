package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.RestauranteDto;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.repository.RestauranteRepository;
import youngdev.restaurantapi.service.RestauranteService;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    @Override
    public List<RestauranteDto> getAllRestaurantes() {
        List<RestauranteEntity> restauranteEntityList = repository.findAll();
        return restauranteEntityList.stream().map(RestauranteDto::new).toList();
    }

    @Override
    public RestauranteDto getRestauranteById(Long id) {
        return repository.findById(id).map(RestauranteDto::new).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public RestauranteDto postRestaurante(RestauranteDto restauranteDto) {
        var restauranteEntity = new RestauranteEntity(restauranteDto);
        var restaurantePersistido = repository.save(restauranteEntity);
        return new RestauranteDto(restaurantePersistido);
    }

    @Override
    public RestauranteDto updateRestaurante(Long id, RestauranteDto updatedRestaurante) {
        Optional<RestauranteEntity> restauranteEntity = repository.findById(id);
        if (restauranteEntity.isPresent()) {
            restauranteEntity.get().updateRestaurante(updatedRestaurante);
            var restaurantePersistido = repository.save(restauranteEntity.get());
            return new RestauranteDto(restaurantePersistido);
        }
        return null;
    }

    @Override
    public void deleteRestaurante(Long id) {
        repository.deleteById(id);
    }

}
