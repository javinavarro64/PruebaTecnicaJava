package es.intricom.pruebaconcepto.ejb.repository;

import es.intricom.pruebaconcepto.persistence.model.ClientEntity;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(ClientRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ClientRepositoryBean extends AbstractCrudRepository<ClientEntity, Integer> implements ClientRepository {

	protected ClientRepositoryBean() {
		super(ClientEntity.class);
	}

	@Override
	public List<ClientEntity> findAll() {
		return entityManager.createQuery("SELECT c FROM ClientEntity c ").getResultList();
	}
}
