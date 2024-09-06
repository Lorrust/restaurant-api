package youngdev.restaurantapi.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import youngdev.restaurantapi.dto.MesaDto;
import youngdev.restaurantapi.entity.QMesaEntity;
import youngdev.restaurantapi.entity.QReservaEntity;
import youngdev.restaurantapi.entity.QRestauranteEntity;
import youngdev.restaurantapi.enums.StatusEnum;
import youngdev.restaurantapi.repository.MesaRepository;
import youngdev.restaurantapi.repository.MesaRepositoryCustom;

import java.time.LocalDate;

public class MesaRepositoryCustomImpl implements MesaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
    final QMesaEntity mesa = QMesaEntity.mesaEntity;
    final QReservaEntity reserva = QReservaEntity.reservaEntity;

    @Override
    public Page<MesaDto> getMesasDisponiveis(Pageable pageable, Long restauranteId, Integer quantidadePessoas, LocalDate data) {
        var query = new JPAQuery<MesaDto>(em);

        query.select(Projections.constructor(MesaDto.class, mesa))
                .distinct()
                .from(restaurante)
                .join(restaurante.mesas, mesa)
                .leftJoin(mesa.reservas, reserva)
                .where(restaurante.id.eq(restauranteId)
                        .and(mesa.capacidadePessoas.goe(quantidadePessoas)
                                .and(reserva.dataReserva.eq(data).not()).or(reserva.status.eq(StatusEnum.CANCELADA))));

        query.limit(pageable.getPageSize());
        query.offset(pageable.getOffset());

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());

    }
}
