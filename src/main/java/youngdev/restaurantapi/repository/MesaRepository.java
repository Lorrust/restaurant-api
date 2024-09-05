package youngdev.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youngdev.restaurantapi.entity.MesaEntity;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Long> {
    List<MesaEntity> findAllByRestauranteId(Long restauranteId);
}
