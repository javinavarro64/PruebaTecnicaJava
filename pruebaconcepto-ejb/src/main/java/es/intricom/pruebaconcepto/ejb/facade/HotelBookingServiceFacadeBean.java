package es.intricom.pruebaconcepto.ejb.facade;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import es.intricom.pruebaconcepto.ejb.interceptor.ExceptionTranslate;
import es.intricom.pruebaconcepto.ejb.interceptor.Logged;
import es.intricom.pruebaconcepto.ejb.repository.ClientRepository;
import es.intricom.pruebaconcepto.ejb.repository.HotelBookingRepository;
import es.intricom.pruebaconcepto.ejb.repository.HotelRepository;
import es.intricom.pruebaconcepto.persistence.model.ClientEntity;
import es.intricom.pruebaconcepto.persistence.model.HotelBookingEntity;
import es.intricom.pruebaconcepto.persistence.model.HotelEntity;
import es.intricom.pruebaconcepto.service.facade.HotelBookingServiceFacade;
import es.intricom.pruebaconcepto.service.model.ClientDTO;
import es.intricom.pruebaconcepto.service.model.HotelBookingDTO;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

@Logged
@ExceptionTranslate
@Stateless
@Local(HotelBookingServiceFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HotelBookingServiceFacadeBean implements HotelBookingServiceFacade {

    @Inject
    private HotelBookingRepository hotelBookingRepository;

    @Inject
    private HotelRepository hotelRepository;

    @Inject
    private ClientRepository clientRepository;

    @Override
    public List<HotelBookingDTO> getAll() {
        List<HotelBookingEntity> reservas = hotelBookingRepository.findAll();
        return reservas.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public HotelBookingDTO get(Integer id) {
        HotelBookingEntity reserva = hotelBookingRepository.findById(id);
        return mapToDto(reserva);
    }

    @Override
    public void create(HotelBookingDTO reserva) {
        HotelEntity hotelEntity = hotelRepository.findById(reserva.getHotel().getId());
        ClientEntity clientEntity = clientRepository.findById(reserva.getCliente().getId());

        HotelBookingEntity bookingEntity = new HotelBookingEntity();
        bookingEntity.setHotel(hotelEntity);
        bookingEntity.setClient(clientEntity);
        bookingEntity.setName(reserva.getName());
        bookingEntity.setAddress(reserva.getAddress());
        bookingEntity.setCreatedDate(reserva.getCreatedDate());

        hotelBookingRepository.create(bookingEntity);
    }

    @Override
    public void update(HotelBookingDTO reserva) {
        HotelEntity hotelEntity = hotelRepository.findById(reserva.getHotel().getId());
        ClientEntity clientEntity = clientRepository.findById(reserva.getCliente().getId());

        HotelBookingEntity bookingEntity = new HotelBookingEntity();
        bookingEntity.setId(reserva.getId());
        bookingEntity.setHotel(hotelEntity);
        bookingEntity.setClient(clientEntity);
        bookingEntity.setName(reserva.getName());
        bookingEntity.setAddress(reserva.getAddress());
        bookingEntity.setCreatedDate(reserva.getCreatedDate());

        hotelBookingRepository.update(bookingEntity);
    }

    private HotelBookingDTO mapToDto(HotelBookingEntity reserva) {
        ClientEntity clientE = reserva.getClient();
        HotelEntity hotelE = reserva.getHotel();

        ClientDTO cliente = new ClientDTO(clientE.getId(), clientE.getName(), clientE.getAddress(), clientE.getPhone(),
                clientE.getCreatedDate());
        HotelDTO hotel = new HotelDTO(hotelE.getId(), hotelE.getName(), hotelE.getAddress(),
                hotelE.getCreatedDate());

        return new HotelBookingDTO(reserva.getId(), hotel, cliente, reserva.getName(), reserva.getAddress(),
                reserva.getCreatedDate());
    }
}
