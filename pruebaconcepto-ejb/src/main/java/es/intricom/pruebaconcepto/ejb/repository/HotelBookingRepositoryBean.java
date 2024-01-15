package es.intricom.pruebaconcepto.ejb.repository;

import es.intricom.pruebaconcepto.persistence.model.HotelBookingEntity;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(HotelBookingRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HotelBookingRepositoryBean extends AbstractCrudRepository<HotelBookingEntity, Long> implements HotelBookingRepository{
    protected HotelBookingRepositoryBean() {  super(HotelBookingEntity.class);  }
}
