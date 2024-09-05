package youngdev.restaurantapi.repository;

import youngdev.restaurantapi.dto.ReservaDto;

import java.util.List;

public interface ReservaRepositoryCustom {

    public List<ReservaDto> getReservasByRestaurante(Long id);

}
