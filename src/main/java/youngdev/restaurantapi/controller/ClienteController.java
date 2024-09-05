package youngdev.restaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youngdev.restaurantapi.dto.ClienteDto;
import youngdev.restaurantapi.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public Page<ClienteDto> getAllClientes(@RequestParam(defaultValue = "0", required = false) Integer page,
                                           @RequestParam(defaultValue = "10", required = false) Integer size,
                                           @RequestParam(required = false) String search) {
        return clienteService.getAllClientes(Pageable.ofSize(size).withPage(page), search);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clienteService.getClienteById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<ClienteDto> getClienteByRestauranteId(@PathVariable Long restauranteId) {
        return clienteService.getClientesByRestauranteId(restauranteId);
    }

    @PostMapping
    public ClienteDto postCliente(@RequestBody ClienteDto newCliente) {
        return clienteService.postCliente(newCliente);
    }

    @PutMapping("/{id}")
    public ClienteDto updateCliente(@PathVariable Long id, @RequestBody ClienteDto updatedCliente) {
        return clienteService.updateCliente(id, updatedCliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

}
