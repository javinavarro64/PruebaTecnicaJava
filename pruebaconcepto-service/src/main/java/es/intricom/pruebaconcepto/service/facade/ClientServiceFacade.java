package es.intricom.pruebaconcepto.service.facade;

import java.util.List;

import es.intricom.pruebaconcepto.service.model.ClientDTO;

public interface ClientServiceFacade {

	public List<ClientDTO> getAll();
	public ClientDTO get(Integer id);
	public void create(ClientDTO hotel);
	public void update(ClientDTO hotel);
}
