package youngdev.restaurantapi.service;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import youngdev.restaurantapi.dto.ClienteDto;
import youngdev.restaurantapi.entity.ClienteEntity;

import java.util.List;

public interface ClienteService {

    Page<ClienteDto> getAllClientes(Pageable pageable, String search);

    ClienteDto getClienteById(Long id);

    ClienteEntity getClienteEntityById(Long id);

    List<ClienteDto> getClientesByRestauranteId(Long restauranteId);

    ClienteDto postCliente(ClienteDto newCliente);

    ClienteDto updateCliente(Long id, ClienteDto updatedCliente);

    void deleteCliente(Long id);
}
