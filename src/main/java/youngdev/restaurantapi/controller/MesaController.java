package youngdev.restaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.service.MesaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<MesaDto> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/disponiveis")
    public Page<MesaDto> getMesasDisponiveis(@RequestParam LocalDate data, @RequestParam Integer quantidadePessoas, @RequestParam Long restauranteId) {
        return mesaService.getMesasDisponiveis(Pageable.ofSize(10), restauranteId, quantidadePessoas, data);
    }

    @GetMapping("/{id}")
    public MesaDto getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @GetMapping("/restaurante/{id}")
    public List<MesaDto> getMesasByRestauranteId(@PathVariable Long id) {
        return mesaService.getMesasByRestauranteId(id);
    }

    @PostMapping
    public MesaDto postMesa(@RequestBody MesaDto mesaDto) {
        return mesaService.postMesa(mesaDto);
    }

    @PutMapping("/{id}")
    public MesaDto updateMesa(@PathVariable Long id, @RequestBody MesaDto mesaDto) {
        return mesaService.updateMesa(id, mesaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }

}
