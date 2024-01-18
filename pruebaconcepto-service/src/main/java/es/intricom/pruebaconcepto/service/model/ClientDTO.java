package es.intricom.pruebaconcepto.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 5484532743348740443L;

	private Integer id;
    private String name;
    private String address;
    private String phone;
    private LocalDateTime createdDate;

    public ClientDTO(Integer id, String name, String address, String phone, LocalDateTime createdDate) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
