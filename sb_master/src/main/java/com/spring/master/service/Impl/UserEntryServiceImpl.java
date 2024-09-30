package com.spring.master.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.master.entity.UserEntry;
import com.spring.master.repository.UserEntryRepository;
import com.spring.master.service.UserEntryService;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Service
public class UserEntryServiceImpl implements UserEntryService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserEntryServiceImpl.class);
	
	@Autowired
	private UserEntryRepository userEntityRepository;
	
	@Override
	public UserEntry addUserEntry(UserEntry userEntry) {
		return userEntityRepository.save(userEntry);
	}

	@Override
	public UserEntry editUserEntry(UserEntry userEntry, String userId) {
		UserEntry user = userEntityRepository.findById(userId).get();
		BeanUtils.copyProperties(user, userEntry);
		return userEntityRepository.save(userEntry);
	}

	@Override
	public UserEntry getUserEntry(String userId) {
		return userEntityRepository.findById(userId).get();
	}

	@Override
	public List<UserEntry> getUserEntries() {
		return userEntityRepository.findAll();
	}

	@Override
	public String deleteUserEntry(String userId) {
		userEntityRepository.deleteById(userId);
		return "";
	}

}
