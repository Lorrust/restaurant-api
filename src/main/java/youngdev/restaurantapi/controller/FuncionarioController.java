package youngdev.restaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDto> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioDto getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }

    @GetMapping("/restaurante/{id}")
    public List<FuncionarioDto> getFuncionarioByRestauranteId(@PathVariable Long id) {
        return funcionarioService.getFuncionariosByRestauranteId(id);
    }

    @PostMapping
    public FuncionarioDto postFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
        return funcionarioService.postFuncionario(funcionarioDto);
    }

    @PutMapping("/{id}")
    public FuncionarioDto updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDto) {
        return funcionarioService.updateFuncionario(id, funcionarioDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
    }

}
