package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.HotelServiceFacade;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

@Named
@ViewScoped
public class HotelListController extends AbstractController implements Serializable {

    private static final long serialVersionUID = -802951726584963559L;

    @EJB
    private HotelServiceFacade hotelServiceFacade;

    public List<HotelDTO> getHotels() {
    	return hotelServiceFacade.getAll();
    }
}
