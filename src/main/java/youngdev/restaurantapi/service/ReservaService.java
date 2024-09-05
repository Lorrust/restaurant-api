package youngdev.restaurantapi.service;

import youngdev.restaurantapi.dto.ReservaDto;

import java.util.List;

public interface ReservaService {

    List<ReservaDto> getAllReservas();

    ReservaDto getReservaById(Long id);

    ReservaDto postReserva(ReservaDto newReserva);

    ReservaDto updateReserva(Long id, ReservaDto updatedReserva);

    void deleteReserva(Long id);
    
}
