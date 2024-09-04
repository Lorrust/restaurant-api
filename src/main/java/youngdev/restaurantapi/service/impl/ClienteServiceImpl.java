package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.ClienteDto;
import youngdev.restaurantapi.entity.ClienteEntity;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.repository.ClienteRepository;
import youngdev.restaurantapi.service.ClienteService;
import youngdev.restaurantapi.service.RestauranteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public List<ClienteDto> getAllClientes() {
        List<ClienteEntity> clienteEntityList = repository.findAll();
        return clienteEntityList.stream().map(ClienteDto::new).toList();
    }

    @Override
    public ClienteDto getClienteById(Long id) {
        return repository.findById(id).map(ClienteDto::new).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<ClienteDto> getClientesByRestauranteId(Long restauranteId) {
        return repository.findAllByRestauranteId(restauranteId).stream().map(ClienteDto::new).toList();
    }

    @Override
    public ClienteDto postCliente(ClienteDto newCliente) {
        var clienteEntity = new ClienteEntity(newCliente, new RestauranteEntity(restauranteService.getRestauranteById(newCliente.getRestaurantId())));
        var clientePersistido = repository.save(clienteEntity);
        return new ClienteDto(clientePersistido);
    }

    @Override
    public ClienteDto updateCliente(Long id, ClienteDto updatedCliente) {
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }
}
