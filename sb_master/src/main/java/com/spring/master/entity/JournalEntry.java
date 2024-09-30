package com.spring.master.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Document(collection = "SB_JOURNAL_ENTRY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {
	
	@Id
	private String journalId;
	
	@NonNull
	private String journalTitle;
	
	@NonNull
	private String journalContent;

	@JsonFormat(pattern = "DD-MM-YYYY")
	private LocalDate date;

	/**
	 * @return the journalId
	 */
	public String getJournalId() {
		return journalId;
	}

	/**
	 * @param journalId the journalId to set
	 */
	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	/**
	 * @return the journalTitle
	 */
	public String getJournalTitle() {
		return journalTitle;
	}

	/**
	 * @param journalTitle the journalTitle to set
	 */
	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}

	/**
	 * @return the journalContent
	 */
	public String getJournalContent() {
		return journalContent;
	}

	/**
	 * @param journalContent the journalContent to set
	 */
	public void setJournalContent(String journalContent) {
		this.journalContent = journalContent;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
}
