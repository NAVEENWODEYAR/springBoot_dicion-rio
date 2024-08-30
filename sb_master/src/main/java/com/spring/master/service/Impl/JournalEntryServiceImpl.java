package com.spring.master.service.Impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.master.entity.JournalEntry;
import com.spring.master.repository.JournalEntryRepository;
import com.spring.master.service.JournalEntryService;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Service
public class JournalEntryServiceImpl implements JournalEntryService{
	
	@Autowired
	private JournalEntryRepository journalEntryRepository;

	@Override
	public JournalEntry addJournal(JournalEntry journalEntry) {
		return journalEntryRepository.save(journalEntry);
	}

	@Override
	public JournalEntry editJournal(JournalEntry journalEntry, String jeId) {
		JournalEntry journal = journalEntryRepository.findById(jeId).get();
		BeanUtils.copyProperties(journal, journalEntry);
		return journalEntryRepository.save(journalEntry);
	}

	@Override
	public JournalEntry getJournal(String jeId) {
		return journalEntryRepository.findById(jeId).get();
	}

	@Override
	public List<JournalEntry> getJournals() {
		return journalEntryRepository.findAll();
	}

	@Override
	public String deleteJournal(String jeId) {
		journalEntryRepository.deleteById(jeId);
		return "";
	}

}
