package com.spring.master.entity;

import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Document(collation = "SB_USER_ENTRY")
public class UserEntry {
	
	@Id
	private Object userId;
	
	@NonNull
	@Indexed(unique = true)
	private String userName;
	
	@NonNull
	private String userPassword;
	
	@DBRef
	private List<JournalEntry> journalEntries = new ArrayList<>();
	 
	public UserEntry() {}

	public UserEntry(Object userId, String userName, String userPassword, List<JournalEntry> journalEntries) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.journalEntries = journalEntries;
	}

	/**
	 * @return the userId
	 */
	public Object getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Object userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the journalEntries
	 */
	public List<JournalEntry> getJournalEntries() {
		return journalEntries;
	}

	/**
	 * @param journalEntries the journalEntries to set
	 */
	public void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}

	@Override
	public int hashCode() {
		return Objects.hash(journalEntries, userId, userName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntry other = (UserEntry) obj;
		return Objects.equals(journalEntries, other.journalEntries) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
	}

	@Override
	public String toString() {
		return "UserEntry [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", journalEntries=" + journalEntries + "]";
	}
	
	
	
}
