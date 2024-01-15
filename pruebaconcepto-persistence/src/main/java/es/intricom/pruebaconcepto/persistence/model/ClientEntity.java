package es.intricom.pruebaconcepto.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "PCO_CLIENT_SEQ", sequenceName = "PCO_CLIENT_SEQ", allocationSize = 1)
@Table(name = "PCO_CLIENT")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 5447502483196695164L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PCO_HOTELBOOKING_SEQ")
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;
}
