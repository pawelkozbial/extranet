package pl.pawel.extranet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "club")
public class Club implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "club_seq", sequenceName = "club_seq")
	@GeneratedValue(generator = "club_seq", strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 6)
	private String name;

	private String description;

	@OneToOne(cascade = CascadeType.PERSIST)
	private District district;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Klub: " + getId() + " " + getName();
	}
}