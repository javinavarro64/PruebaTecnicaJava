package es.intricom.pruebaconcepto.back.model;

import es.intricom.pruebaconcepto.service.facade.HotelServiceFacade;
import es.intricom.pruebaconcepto.service.model.HotelDTO;

import javax.ejb.EJB;
import java.io.Serializable;

public class HotelModel implements Serializable {
    private static final long serialVersionUID = -6817316794222255570L;
    @EJB
    private HotelServiceFacade hotelServiceFacade;

    private HotelDTO value = new HotelDTO();

    public HotelDTO getValue() {
        return value;
    }

    public void setValue(HotelDTO value) {
        this.value = value;
    }


}
