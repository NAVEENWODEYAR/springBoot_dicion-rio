package com.spring.master.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Document(value = "JOURNAL_ENTRY")
@Data
@AllArgsConstructor
public class JournalEntry {
	
	@Id
	private String journalId;
	
	private String journalTitle;
	
	private String journalContent;
	
	private LocalDate date;

}
