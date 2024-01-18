package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.ClientServiceFacade;
import es.intricom.pruebaconcepto.service.facade.HotelBookingServiceFacade;
import es.intricom.pruebaconcepto.service.facade.HotelServiceFacade;
import es.intricom.pruebaconcepto.service.model.ClientDTO;
import es.intricom.pruebaconcepto.service.model.HotelBookingDTO;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

/**
 *
 * Clase para implementar los métodos para editar
 */
@Named
@ViewScoped
public class HotelBookingEditController extends AbstractController implements Serializable {

    private static final long serialVersionUID = -617311328442166925L;

    @EJB
    private HotelBookingServiceFacade hotelBookingServiceFacade;

    @EJB
    private HotelServiceFacade hotelServiceFacade;

    @EJB
    private ClientServiceFacade clientServiceFacade;

    private Integer bookingId;
    private HotelBookingDTO reserva;
    private Integer hotelId;
    private Integer clienteId;
    private HotelDTO hotel;
    private ClientDTO cliente;
    private List<HotelDTO> hoteles;
    private List<ClientDTO> clientes;

    private String name;
    private String address;

    @PostConstruct
    public void postConstruct() {
        hoteles = hotelServiceFacade.getAll();
        clientes = clientServiceFacade.getAll();
        String bookingIdParam = getContext().getExternalContext().getRequestParameterMap().get("bookingId");
        if (bookingIdParam != null) {
            bookingId = Integer.parseInt(bookingIdParam);
            reserva = hotelBookingServiceFacade.get(bookingId);
            hotel = reserva.getHotel();
            cliente = reserva.getCliente();
            name = reserva.getName();
            address = reserva.getAddress();
        }
    }

    public String create() {
        hotelBookingServiceFacade.create(new HotelBookingDTO(bookingId, new HotelDTO(hotelId), new ClientDTO(clienteId),
                name, address, LocalDateTime.now()));
        getContext().addMessage("bookingNew", new FacesMessage("Reserva creada correctamente"));
        return "hotelBookingList";
    }

    public String update() {
        hotelBookingServiceFacade.update(new HotelBookingDTO(bookingId, new HotelDTO(hotelId), new ClientDTO(clienteId),
                name, address, hotel.getCreatedDate()));
        getContext().addMessage("bookingEdit", new FacesMessage("Reserva actualizada correctamente"));
        return "hotelBookingEdit";
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public List<HotelDTO> getHoteles() {
        return hoteles;
    }

    public List<ClientDTO> getClientes() {
        return clientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

}
