package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Lists could be changed to a Set (no order/no duplicates)
@Entity
@Table(name="ASB_USER")
public class AsbUser {
	
	
	@Id
	@Column(name="U_ID")
	@SequenceGenerator(sequenceName="ASBUSER_SEQ", name="ASBUSER_SEQ")
	@GeneratedValue(generator="ASBUSER_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	private String username;
	
	@Column(name="PASS")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	//@ManyToMany 
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USER_BOARDS",
	joinColumns=@JoinColumn(name="U_ID"),
	inverseJoinColumns=@JoinColumn(name="B_ID"))
	private List<Board> boards;

	public AsbUser() {
		this.boards = new ArrayList<Board>();
	}

	public AsbUser(int id, String username, String password, String firstName, String lastName, List<Board> boards) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boards = boards;
	}
	
	

	public AsbUser(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boards = new ArrayList<Board>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "AsbUser [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", boards=" + boards + "]";
	}	
}