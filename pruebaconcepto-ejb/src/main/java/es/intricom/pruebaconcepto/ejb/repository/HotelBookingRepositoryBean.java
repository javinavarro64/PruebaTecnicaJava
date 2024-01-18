package es.intricom.pruebaconcepto.ejb.repository;

import es.intricom.pruebaconcepto.persistence.model.HotelBookingEntity;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(HotelBookingRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HotelBookingRepositoryBean extends AbstractCrudRepository<HotelBookingEntity, Integer>
        implements HotelBookingRepository {

    protected HotelBookingRepositoryBean() {
        super(HotelBookingEntity.class);
    }

    @Override
    public List<HotelBookingEntity> findAll() {
    	return entityManager.createQuery("SELECT r FROM HotelBookingEntity r").getResultList();
    }
}
