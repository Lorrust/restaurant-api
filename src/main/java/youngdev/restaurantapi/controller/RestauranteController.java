package youngdev.restaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youngdev.restaurantapi.dto.RestauranteDto;
import youngdev.restaurantapi.service.RestauranteService;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<RestauranteDto> getAllRestaurantes() {
        return restauranteService.getAllRestaurantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestauranteById(@PathVariable Long id) {
        try {
        return ResponseEntity.ok(restauranteService.getRestauranteById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurante não encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> postRestaurante(@RequestBody RestauranteDto restauranteDto) {
        return ResponseEntity.ok(restauranteService.postRestaurante(restauranteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRestaurante(@PathVariable Long id, @RequestBody RestauranteDto updatedRestaurante) {
        return ResponseEntity.ok(restauranteService.updateRestaurante(id, updatedRestaurante));
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurante(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
    }

}
