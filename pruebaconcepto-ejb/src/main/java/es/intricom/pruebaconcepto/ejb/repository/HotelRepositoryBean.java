package es.intricom.pruebaconcepto.ejb.repository;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import es.intricom.pruebaconcepto.persistence.model.HotelEntity;

@Stateless
@Local(HotelRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HotelRepositoryBean extends AbstractCrudRepository<HotelEntity, Integer> implements HotelRepository {

	protected HotelRepositoryBean() {
		super(HotelEntity.class);
	}

	@Override
	public List<HotelEntity> findAll() {
		return entityManager.createQuery("SELECT h FROM HotelEntity h").getResultList();
	}
}
