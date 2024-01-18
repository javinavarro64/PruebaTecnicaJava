package es.intricom.pruebaconcepto.ejb.facade;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import es.intricom.pruebaconcepto.ejb.interceptor.ExceptionTranslate;
import es.intricom.pruebaconcepto.ejb.interceptor.Logged;
import es.intricom.pruebaconcepto.ejb.repository.ClientRepository;
import es.intricom.pruebaconcepto.persistence.model.ClientEntity;
import es.intricom.pruebaconcepto.service.facade.ClientServiceFacade;
import es.intricom.pruebaconcepto.service.model.ClientDTO;

@Logged
@ExceptionTranslate
@Stateless
@Local(ClientServiceFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClientServiceFacadeBean implements ClientServiceFacade {

    @Inject
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAll() {
        List<ClientEntity> clientes = clientRepository.findAll();
        return clientes.stream().map(cliente -> {
            return new ClientDTO(cliente.getId(), cliente.getName(), cliente.getAddress(), cliente.getPhone(),
                    cliente.getCreatedDate());
        }).collect(Collectors.toList());
    }

    @Override
    public ClientDTO get(Integer id) {
        ClientEntity cliente = clientRepository.findById(id);
        return new ClientDTO(cliente.getId(), cliente.getName(), cliente.getAddress(), cliente.getPhone(), cliente.getCreatedDate());
    }

    @Override
    public void create(ClientDTO cliente) {
        ClientEntity entity = new ClientEntity();
        entity.setName(cliente.getName());
        entity.setAddress(cliente.getAddress());
        entity.setPhone(cliente.getPhone());
        entity.setCreatedDate(cliente.getCreatedDate());
        clientRepository.create(entity);
    }

    @Override
    public void update(ClientDTO cliente) {
        ClientEntity entity = new ClientEntity();
        entity.setId(cliente.getId());
        entity.setName(cliente.getName());
        entity.setAddress(cliente.getAddress());
        entity.setPhone(cliente.getPhone());
        entity.setCreatedDate(cliente.getCreatedDate());
        clientRepository.update(entity);
    }
}
