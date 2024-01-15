package es.intricom.pruebaconcepto.ejb.repository;


import es.intricom.pruebaconcepto.persistence.model.HotelEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(HotelRepository.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HotelRepositoryBean  extends AbstractCrudRepository<HotelEntity, Long> implements HotelRepository{
    protected HotelRepositoryBean() {  super(HotelEntity.class);  }
}
