package pl.pawel.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "game")
public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "game_seq", sequenceName = "game_seq")
	@GeneratedValue(generator = "game_seq", strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany
	private Set<Club> club;

	@OneToMany
	private Set<User> player;

	@OneToMany
	@JoinTable(name = "game_referee", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> referee;

	@DateTimeFormat(iso = ISO.DATE)
	// @NotNull
	private Date dateOfGame;

	@OneToOne
	private Queue queue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Club> getClub() {
		return club;
	}

	public void setClub(Set<Club> club) {
		this.club = club;
	}

	public Set<User> getPlayer() {
		return player;
	}

	public void setPlayer(Set<User> player) {
		this.player = player;
	}

	public Set<User> getReferee() {
		return referee;
	}

	public void setReferee(Set<User> referee) {
		this.referee = referee;
	}

	public Date getDateOfGame() {
		return dateOfGame;
	}

	public void setDateOfGame(Date dateOfGame) {
		this.dateOfGame = dateOfGame;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	@Override
	public String toString() {
		return "GAME: " + getId() + " " + getDateOfGame();
	}
}
