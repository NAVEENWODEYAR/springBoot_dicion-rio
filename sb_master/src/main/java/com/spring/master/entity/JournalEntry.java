package com.spring.master.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Document(collection = "SB_JOURNAL_ENTRY")
@Data
@AllArgsConstructor
public class JournalEntry {
	
	@Id
	private String journalId;
	
	@NonNull
	private String journalTitle;
	
	@NonNull
	private String journalContent;

	@JsonFormat(pattern = "DD-MM-YYYY")
	private LocalDate date;

}
