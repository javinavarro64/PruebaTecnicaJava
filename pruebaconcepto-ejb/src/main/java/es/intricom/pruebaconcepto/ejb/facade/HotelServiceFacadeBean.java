package es.intricom.pruebaconcepto.ejb.facade;

import es.intricom.pruebaconcepto.ejb.interceptor.ExceptionTranslate;
import es.intricom.pruebaconcepto.ejb.interceptor.Logged;
import es.intricom.pruebaconcepto.ejb.repository.HotelRepository;
import es.intricom.pruebaconcepto.persistence.model.HotelEntity;
import es.intricom.pruebaconcepto.service.facade.HotelServiceFacade;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Logged
@ExceptionTranslate
@Stateless
@Local(HotelServiceFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HotelServiceFacadeBean implements HotelServiceFacade {

	@Inject
	private HotelRepository hotelRepository;

	@Override
	public List<HotelDTO> getAll() {
		List<HotelEntity> hoteles = hotelRepository.findAll();
		return hoteles.stream().map(hotel -> {
			return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getAddress(), hotel.getCreatedDate());
		}).collect(Collectors.toList());
	}

	@Override
	public HotelDTO get(Integer id) {
		HotelEntity hotel = hotelRepository.findById(id);
		return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getAddress(), hotel.getCreatedDate());
	}

	@Override
	public void create(HotelDTO hotel) {
		HotelEntity entity = new HotelEntity();
		entity.setName(hotel.getName());
		entity.setAddress(hotel.getAddress());
		entity.setCreatedDate(hotel.getCreatedDate());
		hotelRepository.create(entity);
	}

	@Override
	public void update(HotelDTO hotel) {
		HotelEntity entity = new HotelEntity();
		entity.setId(hotel.getId());
		entity.setName(hotel.getName());
		entity.setAddress(hotel.getAddress());
		entity.setCreatedDate(hotel.getCreatedDate());
		hotelRepository.update(entity);
	}
}
