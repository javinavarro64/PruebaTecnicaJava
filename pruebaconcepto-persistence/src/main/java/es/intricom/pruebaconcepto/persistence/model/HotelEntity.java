package es.intricom.pruebaconcepto.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "PCO_HOTEL_SEQ", sequenceName = "PCO_HOTEL_SEQ", allocationSize = 1)
@Table(name = "PCO_HOTEL")
public class HotelEntity implements Serializable {

    private static final long serialVersionUID = 957649532053164820L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PCO_HOTELBOOKING_SEQ")
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;
}
