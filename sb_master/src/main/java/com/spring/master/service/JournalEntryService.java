package com.spring.master.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.master.entity.JournalEntry;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Service
public interface JournalEntryService {
	
	JournalEntry addJournal(JournalEntry journalEntry);
	
	JournalEntry editJournal(JournalEntry journalEntry,String jeId);
	
	JournalEntry getJournal(String jId);
	
	List<JournalEntry>getJournals();
	
	String deleteJournal(String jId);

}
