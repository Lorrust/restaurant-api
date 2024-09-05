package youngdev.restaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youngdev.restaurantapi.dto.ReservaDto;
import youngdev.restaurantapi.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping()
    public List<ReservaDto> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(reservaService.getReservaById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada");
        }
    }

    @PostMapping
    public ReservaDto postReserva(@RequestBody ReservaDto newReserva) {
        return reservaService.postReserva(newReserva);
    }

    @PutMapping("/{id}")
    public ReservaDto updateReserva(@PathVariable Long id, @RequestBody ReservaDto updatedReserva) {
        return reservaService.updateReserva(id, updatedReserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }
}
