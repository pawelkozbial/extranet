package pl.pawel.extranet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "roles")
@Proxy(lazy = false)
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String authority;
	private String description;
	private List<User> userList;

	public Role() {
		this.setAuthority("ROLE_USER");
	}

	@Id
	@SequenceGenerator(name = "role_seq", sequenceName = "role_seq")
	@GeneratedValue(generator = "role_seq", strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotEmpty
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "role")
	// @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name =
	// "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
	// @JoinColumn(name = "user_id", referencedColumnName = "id") })
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ROLE: " + getId() + " - " + getAuthority() + " - "
				+ getDescription();
	}
}
