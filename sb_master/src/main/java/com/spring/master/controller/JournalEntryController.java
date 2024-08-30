package com.spring.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.master.entity.JournalEntry;
import com.spring.master.service.JournalEntryService;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@RestController
@RequestMapping("/v1/journal")
public class JournalEntryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JournalEntryController.class);
	
	@Autowired
	private JournalEntryService journalEntryService;
	
	@GetMapping
	public ResponseEntity<Object> test(){
		LOGGER.info("Inside test endPoint()");
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body("Welcome to the Journal Entry controller!");
	}
	
	@GetMapping("/{jeId}")
	public ResponseEntity<Object> getJournalEntry(@RequestParam String jeId){
		LOGGER.info("Inside getJournalEntry()");
		JournalEntry journalEntry = journalEntryService.getJournal(jeId);
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body(journalEntry);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> getJournalList(){
		LOGGER.info("Inside getJournalEntryList()");
		List<JournalEntry> journals = journalEntryService.getJournals();
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body(journals);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addJournalEntry(@RequestBody JournalEntry request){
		LOGGER.info("Inside addJournalEntry()");
		JournalEntry journalEntry = journalEntryService.addJournal(request);
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body(journalEntry);
	}
	
	@PutMapping("/jeId")
	public ResponseEntity<Object> updateJournalEntry(@RequestBody JournalEntry request, @PathVariable String jeId){
		LOGGER.info("Inside updateJournalEntry()");
		JournalEntry journalEntry = journalEntryService.editJournal(request, jeId);
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body(journalEntry);
	}
	
	@DeleteMapping("/jeId")
	public ResponseEntity<Object> deleteteJournalEntry(@PathVariable String jeId){
		LOGGER.info("Inside deleteJournalEntry()");
		journalEntryService.deleteJournal(jeId);
		return ResponseEntity.status(HttpStatus.FOUND)
								.header("HttpHeaders.class", "application/json")
								.body("Journal Entry deleted successfully "+jeId);
	}
	
}
