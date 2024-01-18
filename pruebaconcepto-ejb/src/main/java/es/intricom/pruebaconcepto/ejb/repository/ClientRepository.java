package es.intricom.pruebaconcepto.ejb.repository;

import java.util.List;

import es.intricom.pruebaconcepto.persistence.model.ClientEntity;

public interface ClientRepository  extends CrudRepository<ClientEntity, Integer> {

	List<ClientEntity> findAll();
}
