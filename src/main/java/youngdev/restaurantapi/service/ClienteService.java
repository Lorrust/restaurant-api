package youngdev.restaurantapi.service;

import youngdev.restaurantapi.dto.ClienteDto;

import java.util.List;

public interface ClienteService {

    List<ClienteDto> getAllClientes();

    ClienteDto getClienteById(Long id);

    List<ClienteDto> getClientesByRestauranteId(Long restauranteId);

    ClienteDto postCliente(ClienteDto newCliente);

    ClienteDto updateCliente(Long id, ClienteDto updatedCliente);

    void deleteCliente(Long id);
}
