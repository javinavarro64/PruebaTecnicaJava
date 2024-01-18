package es.intricom.pruebaconcepto.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "PCO_HOTELBOOKING_SEQ", sequenceName = "PCO_HOTELBOOKING_SEQ", allocationSize = 1)
@Table(name = "PCO_HOTELBOOKING")
public class HotelBookingEntity implements Serializable {

    private static final long serialVersionUID = -4916249557448137080L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PCO_HOTELBOOKING_SEQ")
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOTEL")
    private HotelEntity hotel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT")
    private ClientEntity client;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
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
