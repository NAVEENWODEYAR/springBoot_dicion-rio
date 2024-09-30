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

import com.spring.master.entity.UserEntry;
import com.spring.master.service.UserEntryService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Tag(name = "UserEntry_Controller",description = "User_Entity related API's,,")
@RestController
@RequestMapping("/v1/user")
public class UserEntryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserEntryController.class);

	@Autowired
	private UserEntryService userEntryService;

	@GetMapping
	public ResponseEntity<Object> test() {
		LOGGER.info("Inside test endPoint()");
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body("Welcome to the Journal Entry controller!");
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUserEntry(@RequestParam String userId) {
		LOGGER.info("Inside getJournalEntry() {}",userId);
		UserEntry userEntry = userEntryService.getUserEntry(userId);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body(userEntry);
	}

	@GetMapping("/list")
	public ResponseEntity<Object> getJournalList() {
		LOGGER.info("Inside getJournalEntryList()");
		List<UserEntry> userEntries = userEntryService.getUserEntries();
		return ResponseEntity.status(HttpStatus.FOUND)
				.header("HttpHeaders.class", "application/json")
				.body(userEntries);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addJournalEntry(@RequestBody UserEntry request) {
		LOGGER.info("Inside addJournalEntry()");
		UserEntry userEntry = userEntryService.addUserEntry(request);
		return ResponseEntity.status(HttpStatus.FOUND).header("HttpHeaders.class", "application/json")
				.body(userEntry);
	}

	@PutMapping("/userId")
	public ResponseEntity<Object> updateJournalEntry(@RequestBody UserEntry request, @PathVariable String userId) {
		LOGGER.info("Inside updateJournalEntry()");
		UserEntry userEntry = userEntryService.editUserEntry(request, userId);
		return ResponseEntity.status(HttpStatus.FOUND)
				.header("HttpHeaders.class", "application/json")
				.body(userEntry);
	}

	@DeleteMapping("/userId")
	public ResponseEntity<Object> deleteteJournalEntry(@PathVariable String userId) {
		LOGGER.info("Inside deleteJournalEntry()");
		userEntryService.deleteUserEntry(userId);
		return ResponseEntity.status(HttpStatus.FOUND)
				.header("HttpHeaders.class", "application/json")
				.body("Journal Entry deleted successfully " + userId);
	}

}
