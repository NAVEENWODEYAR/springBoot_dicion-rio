package com.spring.master.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.master.entity.UserEntry;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Service
public interface UserEntryService {
	
	UserEntry addUserEntry(UserEntry userEntry);
	
	UserEntry editUserEntry(UserEntry userEntry,String userId);
	
	UserEntry getUserEntry(String userId);
	
	List<UserEntry>getUserEntries();
	
	String deleteUserEntry(String userId);

}
