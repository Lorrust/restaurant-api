package youngdev.restaurantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youngdev.restaurantapi.entity.ClienteEntity;
import youngdev.restaurantapi.entity.FuncionarioEntity;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    List<FuncionarioEntity> findAllByRestauranteId(Long restauranteId);
}
