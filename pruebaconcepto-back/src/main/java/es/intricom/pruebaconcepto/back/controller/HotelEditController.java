package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.HotelServiceFacade;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

@Named
@ViewScoped
public class HotelEditController extends AbstractController implements Serializable {
    private static final long serialVersionUID = 8968307099990354164L;

    @EJB
    private HotelServiceFacade hotelServiceFacade;

	private Integer hotelId;
    private HotelDTO hotel;

    private String name;
    private String address;

    @PostConstruct
    public void postConstruct() {
		String hotelIdParam = getContext().getExternalContext().getRequestParameterMap()
				.get("hotelId");
        if (hotelIdParam != null) {
            hotelId = Integer.parseInt(hotelIdParam);
            hotel = hotelServiceFacade.get(hotelId);
            name = hotel.getName();
            address = hotel.getAddress();
        }
    }

    public String create() {
    	hotelServiceFacade.create(new HotelDTO(hotelId, name, address, LocalDateTime.now()));
    	getContext().addMessage("hotelNew", new FacesMessage("Hotel creado correctamente"));
    	return "hotelList";
    }

    public String update() {
    	hotelServiceFacade.update(new HotelDTO(hotelId, name, address, hotel.getCreatedDate()));
    	getContext().addMessage("hotelEdit", new FacesMessage("Hotel actualizado correctamente"));
    	return "hotelEdit";
    }

	public HotelDTO getHotel() {
		return hotel;
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
}
