package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.ClientServiceFacade;
import es.intricom.pruebaconcepto.service.model.ClientDTO;

@Named
@ViewScoped
public class ClientListController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 5008696891240517684L;

    @EJB
    private ClientServiceFacade clientServiceFacade;

    public List<ClientDTO> getClients() {
    	return clientServiceFacade.getAll();
    }
}
