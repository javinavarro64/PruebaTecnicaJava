package es.intricom.pruebaconcepto.ejb.repository;

import java.util.List;

import es.intricom.pruebaconcepto.persistence.model.HotelEntity;

public interface HotelRepository extends CrudRepository<HotelEntity, Integer> {

	List<HotelEntity> findAll();
}
