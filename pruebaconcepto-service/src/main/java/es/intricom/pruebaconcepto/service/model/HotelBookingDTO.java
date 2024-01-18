package es.intricom.pruebaconcepto.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HotelBookingDTO implements Serializable {

    private static final long serialVersionUID = 8872088048508559340L;

    private Integer id;
    private HotelDTO hotel;
    private ClientDTO cliente;
    private String name;
    private String address;
    private LocalDateTime createdDate;

    public HotelBookingDTO(Integer id, HotelDTO hotel, ClientDTO cliente, String name, String address,
            LocalDateTime createdDate) {
        super();
        this.id = id;
        this.hotel = hotel;
        this.cliente = cliente;
        this.name = name;
        this.address = address;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientDTO cliente) {
        this.cliente = cliente;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
