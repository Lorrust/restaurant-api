package youngdev.restaurantapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import youngdev.restaurantapi.dto.ClienteDto;
import youngdev.restaurantapi.entity.ClienteEntity;
import youngdev.restaurantapi.entity.RestauranteEntity;
import youngdev.restaurantapi.repository.ClienteRepository;
import youngdev.restaurantapi.service.ClienteService;
import youngdev.restaurantapi.service.RestauranteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public Page<ClienteDto> getAllClientes(Pageable pageable, String search) {
        Page<ClienteEntity> clienteEntityPage;
        if (search != null && !search.isEmpty()) {
            clienteEntityPage = repository.findByNomeContaining(search, pageable);
        } else {
            clienteEntityPage = repository.findAll(pageable);
        }
        return clienteEntityPage.map(ClienteDto::new);
    }


    @Override
    public ClienteDto getClienteById(Long id) {
        return repository.findById(id).map(ClienteDto::new).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public ClienteEntity getClienteEntityById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<ClienteDto> getClientesByRestauranteId(Long restauranteId) {
        return repository.findAllByRestauranteId(restauranteId).stream().map(ClienteDto::new).toList();
    }

    @Override
    public ClienteDto postCliente(ClienteDto newCliente) {
        String correctCpf = cleanCpf(newCliente.getCpf());

        var clienteEntity = new ClienteEntity(newCliente, new RestauranteEntity(restauranteService.getRestauranteById(newCliente.getRestaurantId())));
        clienteEntity.setCpf(correctCpf);

        var clientePersistido = repository.save(clienteEntity);
        return new ClienteDto(clientePersistido);
    }

    @Override
    public ClienteDto updateCliente(Long id, ClienteDto updatedCliente) {
        Optional<ClienteEntity> clienteEntity = repository.findById(id);
        if (clienteEntity.isPresent()) {
            clienteEntity.get().updateCliente(updatedCliente);
            var clientePersistido = repository.save(clienteEntity.get());
            return new ClienteDto(clientePersistido);
        }
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }

    private String cleanCpf(String cpf) {
        String numberCpf = cpf.replaceAll("\\D", "");
        if (numberCpf.isEmpty()) {
            throw new IllegalArgumentException("CPF invalido");
        }
        return numberCpf;
    }

}
