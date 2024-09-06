package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.FuncionarioDto;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.entity.MesaEntity;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.repository.MesaRepository;
import youngdev.restaurantapi.service.MesaService;
import youngdev.restaurantapi.service.RestauranteService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository repository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public List<MesaDto> getAllMesas() {
        List<MesaEntity> MesaEntityList = repository.findAll();
        return MesaEntityList.stream().map(MesaDto::new).toList();
    }

    @Override
    public Page<MesaDto> getMesasDisponiveis(Pageable pageable, Long restauranteId, Integer numPessoas, LocalDate data) {
        return repository.getMesasDisponiveis(pageable, restauranteId, numPessoas, data);
    }

    @Override
    public MesaDto getMesaById(Long id) {
        return repository.findById(id).map(MesaDto::new).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public MesaEntity getMesaEntityById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<MesaDto> getMesasByRestauranteId(Long restauranteId) {
        return repository.findAllByRestauranteId(restauranteId).stream().map(MesaDto::new).toList();
    }

    @Override
    public MesaDto postMesa(MesaDto newMesa) {
        var restaurante = restauranteService.getRestauranteById(newMesa.getRestauranteId());
        var MesaEntity = new MesaEntity(newMesa, new RestauranteEntity(restaurante));
        var MesaPersistido = repository.save(MesaEntity);
        return new MesaDto(MesaPersistido);
    }

    @Override
    public MesaDto updateMesa(Long id, MesaDto updatedMesa) {
        Optional<MesaEntity> MesaEntity = repository.findById(id);
        if (MesaEntity.isPresent()) {
            MesaEntity.get().updateMesa(updatedMesa);
            var MesaPersistido = repository.save(MesaEntity.get());
            return new MesaDto(MesaPersistido);
        }
        return null;
    }

    @Override
    public void deleteMesa(Long id) {
        repository.deleteById(id);
    }

}
