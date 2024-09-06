package youngdev.restaurantapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.entity.MesaEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Long> {

    List<MesaEntity> findAllByRestauranteId(Long restauranteId);

    Page<MesaDto> getMesasDisponiveis(Pageable pageable, Long restauranteId, Integer numPessoas, LocalDate data);

}
