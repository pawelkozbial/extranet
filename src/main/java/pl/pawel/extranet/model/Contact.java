package pl.pawel.extranet.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "con_seq", sequenceName = "con_seq")
	@GeneratedValue(generator = "con_seq", strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String firstname;

	@Basic
	// @NotEmpty(message = "Pole nie może być puste")
	@Size(min = 5, max = 30, message = "Pole musi mieć rozmiar od {min} do {max}")
	private String lastname;

	public void clear() {
		this.setFirstname(null);
		this.setLastname(null);
		this.setEmail(null);
		this.setTelephone(null);
	}

	@NotEmpty
	private String email;

	private String telephone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
