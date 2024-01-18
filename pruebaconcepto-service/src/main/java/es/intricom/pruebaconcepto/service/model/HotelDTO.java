package es.intricom.pruebaconcepto.service.model;

import java.time.LocalDateTime;

public class HotelDTO {

    private Integer id;
    private String name;
    private String address;
    private LocalDateTime createdDate;

    public HotelDTO(Integer id) {
        this.id = id;
    }

    public HotelDTO(Integer id, String name, String address, LocalDateTime createdDate) {
        this(id);
        this.name = name;
        this.address = address;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
