package es.intricom.pruebaconcepto.ejb.repository;

import java.util.List;

import es.intricom.pruebaconcepto.persistence.model.HotelBookingEntity;

public interface HotelBookingRepository extends CrudRepository<HotelBookingEntity, Integer> {

	List<HotelBookingEntity> findAll();
}
