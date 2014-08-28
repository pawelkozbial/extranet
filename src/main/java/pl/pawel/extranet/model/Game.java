package pl.pawel.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Club> club;

	@ManyToMany
	@JoinTable(name = "game_playerOne", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> playerClubOne;

	@ManyToMany
	@JoinTable(name = "game_playerTwo", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> playerClubTwo;

	@ManyToMany
	@JoinTable(name = "game_referee", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> referee;

	@DateTimeFormat(iso = ISO.DATE)
	// @NotNull
	private Date dateOfGame;

	@OneToOne(fetch = FetchType.EAGER)
	private Queue queue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Club> getClub() {
		return club;
	}

	public void setClub(List<Club> club) {
		this.club = club;
	}

	public List<User> getPlayerClubOne() {
		return playerClubOne;
	}

	public void setPlayerClubOne(List<User> playerClubOne) {
		this.playerClubOne = playerClubOne;
	}

	public List<User> getPlayerClubTwo() {
		return playerClubTwo;
	}

	public void setPlayerClubTwo(List<User> playerClubTwo) {
		this.playerClubTwo = playerClubTwo;
	}

	public List<User> getReferee() {
		return referee;
	}

	public void setReferee(List<User> referee) {
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
