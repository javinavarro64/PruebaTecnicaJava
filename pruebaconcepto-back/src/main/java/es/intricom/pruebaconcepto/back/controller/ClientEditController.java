package es.intricom.pruebaconcepto.back.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import es.intricom.pruebaconcepto.service.facade.ClientServiceFacade;
import es.intricom.pruebaconcepto.service.model.ClientDTO;

@Named
@ViewScoped
public class ClientEditController extends AbstractController implements Serializable {

    private static final long serialVersionUID = 7698023034062451999L;

    @EJB
    private ClientServiceFacade clientServiceFacade;

    private Integer clientId;
    private ClientDTO cliente;

    private String name;
    private String address;
    private String phone;

    @PostConstruct
    public void postConstruct() {
        String clientIdParam = getContext().getExternalContext().getRequestParameterMap().get("clientId");
        if (clientIdParam != null) {
            clientId = Integer.parseInt(clientIdParam);
            cliente = clientServiceFacade.get(clientId);
            name = cliente.getName();
            address = cliente.getAddress();
            phone = cliente.getPhone();
        }
    }

    public String create() {
        clientServiceFacade.create(new ClientDTO(clientId, name, address, phone, LocalDateTime.now()));
        getContext().addMessage("clientNew", new FacesMessage("Cliente creado correctamente"));
        return "clientList";
    }

    public String update() {
        clientServiceFacade.update(new ClientDTO(clientId, name, address, phone, cliente.getCreatedDate()));
        getContext().addMessage("clientEdit", new FacesMessage("Cliente actualizado correctamente"));
        return "clientEdit";
    }

    public ClientDTO getCliente() {
        return cliente;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
