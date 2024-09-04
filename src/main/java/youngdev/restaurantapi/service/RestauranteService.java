package youngdev.restaurantapi.service;

import org.springframework.http.ResponseEntity;
import youngdev.restaurantapi.dto.RestauranteDto;

import java.util.List;

public interface RestauranteService {

    List<RestauranteDto> getAllRestaurantes();

    RestauranteDto getRestauranteById(Long id);

    RestauranteDto postRestaurante(RestauranteDto restauranteDto);

    RestauranteDto updateRestaurante(Long id, RestauranteDto restauranteDto);

    void deleteRestaurante(Long id);
}
