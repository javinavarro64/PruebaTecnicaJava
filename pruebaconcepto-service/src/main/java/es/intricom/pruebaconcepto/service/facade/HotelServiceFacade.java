package es.intricom.pruebaconcepto.service.facade;

import java.util.List;

import es.intricom.pruebaconcepto.service.model.HotelDTO;

public interface HotelServiceFacade {

	public List<HotelDTO> getAll();
	public HotelDTO get(Integer id);
	public void create(HotelDTO hotel);
	public void update(HotelDTO hotel);
}
