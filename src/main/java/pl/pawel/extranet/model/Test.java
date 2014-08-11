package pl.pawel.extranet.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "test")
public class Test {

	@Id
	@SequenceGenerator(name = "test_seq", sequenceName = "test_seq")
	@GeneratedValue(generator = "test_seq", strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
