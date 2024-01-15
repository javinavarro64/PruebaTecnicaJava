package es.intricom.pruebaconcepto.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "PCO_HOTELBOOKING_SEQ", sequenceName = "PCO_HOTELBOOKING_SEQ", allocationSize = 1)
@Table(name = "PCO_HOTELBOOKING")
public class HotelBookingEntity implements Serializable {
    private static final long serialVersionUID = -4916249557448137080L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PCO_HOTELBOOKING_SEQ")
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;
}
