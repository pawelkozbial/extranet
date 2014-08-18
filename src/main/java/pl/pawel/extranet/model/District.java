package pl.pawel.extranet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "district")
public class District implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "district_seq", sequenceName = "district_seq")
	@GeneratedValue(generator = "district_seq", strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 6)
	private String name;

	private String description;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "league_district", joinColumns = { @JoinColumn(name = "district_id") }, inverseJoinColumns = { @JoinColumn(name = "league_id") })
	private League league;

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

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

}
