package com.spring.master.controller;

import java.util.List;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.master.entity.JournalEntry;
import com.spring.master.service.JournalEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Tag(name = "JournalEntry_Controller",description = "Journal_Entry CRUD API's,")
@RestController
@RequestMapping("/v1/journal")
public class JournalEntryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JournalEntryController.class);

	@Autowired
	private JournalEntryService journalEntryService;

	@GetMapping
	public ResponseEntity<Object> test() {
		LOGGER.info("Inside test endPoint()");
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body("Welcome to the Journal Entry controller!");
	}

	@GetMapping("/{jeId}")
	public ResponseEntity<Object> getJournalEntry(@RequestParam String jeId) {
		LOGGER.info("Inside getJournalEntry()");
		JournalEntry journalEntry = journalEntryService.getJournal(jeId);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body(journalEntry);
	}

	@GetMapping("/list")
	public ResponseEntity<Object> getJournalList() {
		LOGGER.info("Inside getJournalEntryList()");
		List<JournalEntry> journals = journalEntryService.getJournals();
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json").body(journals);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addJournalEntry(@RequestBody JournalEntry request) {
		LOGGER.info("Inside addJournalEntry() {}",request);
		JournalEntry journalEntry = journalEntryService.addJournal(request);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body(journalEntry);
	}

	@PutMapping("/jeId")
	public ResponseEntity<Object> updateJournalEntry(@RequestBody JournalEntry request, @PathVariable String jeId) {
		LOGGER.info("Inside updateJournalEntry() {}");
		JournalEntry journalEntry = journalEntryService.editJournal(request, jeId);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body(journalEntry);
	}

	@DeleteMapping("/jeId")
	public ResponseEntity<Object> deleteJournalEntry(@PathVariable String jeId) {
		LOGGER.info("Inside deleteJournalEntry()");
		LOGGER.error("DeleteJournalEntry {}", jeId);
		journalEntryService.deleteJournal(jeId);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body("Journal Entry deleted successfully " + jeId);
	}

}
