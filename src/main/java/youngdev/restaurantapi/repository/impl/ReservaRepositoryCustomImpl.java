package youngdev.restaurantapi.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import youngdev.restaurantapi.dto.ReservaDto;
import youngdev.restaurantapi.entity.QRestauranteEntity;
import youngdev.restaurantapi.repository.ReservaRepositoryCustom;

import java.util.List;

public class ReservaRepositoryCustomImpl implements ReservaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QRestauranteEntity reserva = QRestauranteEntity.restauranteEntity;

    @Override
    public List<ReservaDto> getReservasByRestaurante(Long id) {
        return List.of();
    }
}
