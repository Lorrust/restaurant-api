package youngdev.restaurantapi.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import youngdev.restaurantapi.dto.ReservaDto;
import youngdev.restaurantapi.entity.QRestauranteEntity;
import youngdev.restaurantapi.repository.ReservaRepositoryCustom;

import java.util.List;

public class ReservaRepositoryCustomImpl implements ReservaRepositoryCustom {

//    TODO: Create custom query to obtain all reservas associated to a specific restaurant
    @PersistenceContext
    private EntityManager em;

    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;

    @Override
    public List<ReservaDto> getReservasByRestaurante(Long id) {
        return List.of();
    }
}
