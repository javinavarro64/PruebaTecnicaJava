package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.HotelBookingServiceFacade;
import es.intricom.pruebaconcepto.service.model.HotelBookingDTO;

/**
 *
 * Clase para implementar los métodos para listar
 */
@Named
@ViewScoped
public class HotelBookingListController extends AbstractController implements Serializable {

    private static final long serialVersionUID = -2930645152386822167L;

    @EJB
    private HotelBookingServiceFacade hotelBookingServiceFacade;

    public List<HotelBookingDTO> getBookings() {
    	return hotelBookingServiceFacade.getAll();
    }
}
