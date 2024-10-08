package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.ReservaDto;
import youngdev.restaurantapi.entity.ReservaEntity;
import youngdev.restaurantapi.enums.StatusEnum;
import youngdev.restaurantapi.repository.ReservaRepository;
import youngdev.restaurantapi.service.ClienteService;
import youngdev.restaurantapi.service.MesaService;
import youngdev.restaurantapi.service.ReservaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MesaService mesaService;

    @Override
    public List<ReservaDto> getAllReservas() {
        List<ReservaEntity> reservaEntityList = repository.findAll();
        return reservaEntityList.stream().map(ReservaDto::new).toList();
    }

    @Override
    public ReservaDto getReservaById(Long id) {
        return repository.findById(id).map(ReservaDto::new).orElseThrow(IllegalArgumentException::new);
    }

//    @Override
//    public List<ReservaDto> getReservasByRestauranteId(Long restauranteId) {
//        return repository.findAllByRestauranteId(restauranteId).stream().map(ReservaDto::new).toList();

    @Override
    public ReservaDto postReserva(ReservaDto newReserva) {
        validateReserva(newReserva);
        var cliente = clienteService.getClienteEntityById(newReserva.getClienteId());
        var mesa = mesaService.getMesaEntityById(newReserva.getMesaId());
        var reservaEntity = new ReservaEntity(newReserva, cliente, mesa);
        var reservaPersistido = repository.save(reservaEntity);
        return new ReservaDto(reservaPersistido);
    }

    @Override
    public ReservaDto updateReserva(Long id, ReservaDto updatedReserva) {
        Optional<ReservaEntity> reservaEntity = repository.findById(id);
        if (reservaEntity.isPresent()) {
            if (StatusEnum.CANCELADA.equals(updatedReserva.getStatus())) {
                if (LocalDate.now().isBefore(getReservaById(id).getDataReserva())) {
                    reservaEntity.get().updateReserva(updatedReserva);
                    var reservaPersistido = repository.save(reservaEntity.get());
                    return new ReservaDto(reservaPersistido);
                } else {
                    throw new IllegalArgumentException("Deve-se cancelar a reserva com um dia de antecedencia");
                }
            }
            reservaEntity.get().updateReserva(updatedReserva);
            var reservaPersistido = repository.save(reservaEntity.get());
            return new ReservaDto(reservaPersistido);
        }
        return null;
    }

    @Override
    public void deleteReserva(Long id) {
        repository.deleteById(id);
    }

    public void validateReserva(ReservaDto reservaDto) {
        pastReserva(reservaDto.getDataReserva());
    }

    public void pastReserva(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data invalida");
        }
    }

}
