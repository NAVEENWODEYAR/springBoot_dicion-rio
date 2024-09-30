package com.spring.master.service.Impl;
/**
 * @author NaveenWodeyar
 * @date 29-Sept-2024
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JournalEntryServiceImplTest {
	
	private JournalEntryServiceImpl entryServiceImpl;
	
	 @BeforeEach
	    void setUp() {
	        entryServiceImpl = new JournalEntryServiceImpl(); 
	    }

	@Test
	@DisplayName(value = "Dummy Test")
	void test() {
		fail("Not yet implemented");
		assertEquals("Dummy test case,", entryServiceImpl.test());
	}

}
