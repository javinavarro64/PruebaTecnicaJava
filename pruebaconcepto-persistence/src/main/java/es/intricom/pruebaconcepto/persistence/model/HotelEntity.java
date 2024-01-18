package es.intricom.pruebaconcepto.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "PCO_HOTEL_SEQ", sequenceName = "PCO_HOTEL_SEQ", allocationSize = 1)
@Table(name = "PCO_HOTEL")
public class HotelEntity implements Serializable {

	private static final long serialVersionUID = 957649532053164820L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PCO_HOTEL_SEQ")
	@Column(name = "ID", nullable = false, length = 10)
	private Integer id;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CREATED_DATE")
	@NotNull
	private LocalDateTime createdDate;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
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
