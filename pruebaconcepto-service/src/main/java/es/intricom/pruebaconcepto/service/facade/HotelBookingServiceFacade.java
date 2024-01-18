package es.intricom.pruebaconcepto.service.facade;

import java.util.List;

import es.intricom.pruebaconcepto.service.model.HotelBookingDTO;

public interface HotelBookingServiceFacade {

    public List<HotelBookingDTO> getAll();
    public HotelBookingDTO get(Integer id);
    public void create(HotelBookingDTO reserva);
    public void update(HotelBookingDTO reserva);
}
