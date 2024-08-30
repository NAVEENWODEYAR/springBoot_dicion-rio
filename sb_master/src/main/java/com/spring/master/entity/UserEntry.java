package com.spring.master.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "SB_USER_ENTRY")
public class UserEntry {
	
	@Id
	private Object userId;
	
	@NonNull
	@Indexed(unique = true)
	private String userName;
	
	@NonNull
	private String userPassword;
	
	@DBRef
	private List<JournalEntry> jounalEntires = new ArrayList<>();
	 

}
