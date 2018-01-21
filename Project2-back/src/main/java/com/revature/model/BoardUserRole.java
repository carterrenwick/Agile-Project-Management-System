package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * boolean instance variables may need to be changed to type int
 * in order to reflect DB schema
 * 
 * permissions in this class are subject to change
 */

@Entity
@Table(name="BOARD_USER_ROLE")
public class BoardUserRole {

	
	@Id
	@Column(name="BUR_ID")
	@SequenceGenerator(sequenceName="BUR_SEQ", name="BUR_SEQ")
	@GeneratedValue(generator="BUR_SEQ",
	strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Column(name="CREATE_C")
	private boolean createCard;
	
	@Column(name="MOVE_C")
	private boolean moveCard;
	
	
	@Column(name="EDIT_C")
	private boolean editCard;
	
	@Column(name="INVITE_U")
	private boolean inviteUser;
	
	@Column(name="CREATE_S")
	private boolean createSwimLane;
	
	public BoardUserRole() {}

	public BoardUserRole(int id, String roleName, boolean createCard, boolean moveCard, boolean editCard,
			boolean inviteUser, boolean createSwimLane) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.createCard = createCard;
		this.moveCard = moveCard;
		this.editCard = editCard;
		this.inviteUser = inviteUser;
		this.createSwimLane = createSwimLane;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isCreateCard() {
		return createCard;
	}

	public void setCreateCard(boolean createCard) {
		this.createCard = createCard;
	}

	public boolean isMoveCard() {
		return moveCard;
	}

	public void setMoveCard(boolean moveCard) {
		this.moveCard = moveCard;
	}

	public boolean isEditCard() {
		return editCard;
	}

	public void setEditCard(boolean editCard) {
		this.editCard = editCard;
	}

	public boolean isInviteUser() {
		return inviteUser;
	}

	public void setInviteUser(boolean inviteUser) {
		this.inviteUser = inviteUser;
	}

	public boolean isCreateSwimLane() {
		return createSwimLane;
	}

	public void setCreateSwimLane(boolean createSwimLane) {
		this.createSwimLane = createSwimLane;
	}

	@Override
	public String toString() {
		return "BoardUserRole [id=" + id + ", roleName=" + roleName + ", createCard=" + createCard + ", moveCard="
				+ moveCard + ", editCard=" + editCard + ", inviteUser=" + inviteUser + ", createSwimLane="
				+ createSwimLane + "]";
	}	
}