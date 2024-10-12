package com.spring.master.service.Impl;
/**
 * @author NaveenWodeyar
 * @date 04-Oct-2024
 */

import com.spring.master.entity.UserEntry;
import com.spring.master.repository.UserEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserEntryServiceImplTest {

    @InjectMocks
    private UserEntryServiceImpl userEntryService;

    @Mock
    private UserEntryRepository userEntryRepository;

    private UserEntry userEntry;
    private final Object userId = "testUserId";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userEntry = new UserEntry();
        userEntry.setUserId(userId);
        userEntry.setUserName("Test User"); 
    }

    @Test
    void addUserEntry_ShouldSaveAndReturnUserEntry() {
        when(userEntryRepository.save(any(UserEntry.class))).thenReturn(userEntry);

        UserEntry result = userEntryService.addUserEntry(userEntry);

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        verify(userEntryRepository, times(1)).save(userEntry);
    }

    @Test
    void editUserEntry_ShouldUpdateAndReturnUserEntry() {
        UserEntry updatedUserEntry = new UserEntry();
        updatedUserEntry.setUserId(userId);
        updatedUserEntry.setUserName("Updated User");

        when(userEntryRepository.findById(userId)).thenReturn(Optional.of(userEntry));
        when(userEntryRepository.save(any(UserEntry.class))).thenReturn(updatedUserEntry);

        UserEntry result = userEntryService.editUserEntry(updatedUserEntry, " ");

        assertNotNull(result);
        assertEquals("Updated User", result.getUserName());
        verify(userEntryRepository, times(1)).findById(userId);
        verify(userEntryRepository, times(1)).save(updatedUserEntry);
    }

    @Test
    void getUserEntry_ShouldReturnUserEntry() {
        when(userEntryRepository.findById(userId)).thenReturn(Optional.of(userEntry));

        UserEntry result = userEntryService.getUserEntry("userId");

        assertNotNull(result);
        assertEquals(userId, result.getUserId());
        verify(userEntryRepository, times(1)).findById(userId);
    }

    @Test
    void getUserEntries_ShouldReturnListOfUserEntries() {
        when(userEntryRepository.findAll()).thenReturn(List.of(userEntry));

        List<UserEntry> result = userEntryService.getUserEntries();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(userEntryRepository, times(1)).findAll();
    }

    @Test
    void deleteUserEntry_ShouldDeleteUserEntry() {
        doNothing().when(userEntryRepository).deleteById(userId);

        String result = userEntryService.deleteUserEntry("userId");

        assertEquals("", result);
        verify(userEntryRepository, times(1)).deleteById(userId);
    }
}
