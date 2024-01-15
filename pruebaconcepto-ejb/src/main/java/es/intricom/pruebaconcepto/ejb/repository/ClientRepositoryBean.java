package es.intricom.pruebaconcepto.ejb.repository;

import es.intricom.pruebaconcepto.persistence.model.ClientEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(ClientRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ClientRepositoryBean extends AbstractCrudRepository<ClientEntity, Long> implements ClientRepository{
    protected ClientRepositoryBean() {  super(ClientEntity.class);  }
}
