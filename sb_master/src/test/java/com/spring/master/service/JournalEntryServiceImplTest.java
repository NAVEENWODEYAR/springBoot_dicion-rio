package com.spring.master.service;
/**
 * @author NaveenWodeyar
 * @date 23-Sept-2024
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import com.spring.master.service.Impl.JournalEntryServiceImpl;

public class JournalEntryServiceImplTest {
	
	JournalEntryServiceImpl journalEntryServiceImpl = new JournalEntryServiceImpl();
	
	@Test
	public void dummyTest() {
		when(journalEntryServiceImpl.test()).thenReturn("Dummy test case,");
		assertEquals("Dummy test case,", journalEntryServiceImpl.test());
	}

}
