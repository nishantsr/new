package com.cybage.program;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.models.Users;
import com.cybage.repositories.UserRepository;
import com.cybage.services.UserService;

@SpringBootTest
public class MainProjectApplicationTests {
	@MockBean
	private UserRepository repository;
	
	@Autowired
	private UserService service;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testUpdateUserById() {
		Users user15 = new Users();
		user15.setEmailId("manish@cybage.com");
        user15.setFirstName("Manish");
        user15.setLastName("Sahu");
        user15.setMobile("0000000");
        user15.setPassword("abc");
        user15.setRole("passenger");
        user15.setUserId(1);
        user15.setUsername("manish");
        
        Mockito.when(repository.findByEmailId("manish@cybage.com")).thenReturn(user15);
        user15.setPassword("qwerty");
        Mockito.when(repository.save(user15)).thenReturn(user15);
        assertThat(service.updateUserById(1, user15)).isEqualTo(user15);

	}

	@Test
	public void testGetUsers() {
		Users user13 = new Users();
        user13.setEmailId("majid@cybage.com");
        user13.setFirstName("Majid");
        user13.setLastName("Siddiqui");
        user13.setMobile("528653555");
        user13.setPassword("xyz");
        user13.setRole("passenger");
        user13.setUserId(1);
        user13.setUsername("majid");
        
        Users user14 = new Users();
        user14.setEmailId("manish@cybage.com");
        user14.setFirstName("Manish");
        user14.setLastName("Sahu");
        user14.setMobile("0000000");
        user14.setPassword("abc");
        user14.setRole("passenger");
        user14.setUserId(1);
        user14.setUsername("manish");
        
        List<Users> userList = new ArrayList<Users>();
        userList.add(user13);
        userList.add(user14);
        
        Mockito.when(repository.findAll()).thenReturn(userList);
        assertThat(service.getUsers()).isEqualTo(userList);

	}

//	@Test
//	public void testUpdateUser() {
//		Users user16= new Users();
//		user16.setEmailId("manish@cybage.com");
//        user16.setFirstName("Manish");
//        user16.setLastName("Sahu");
//        user16.setMobile("0000000");
//        user16.setPassword("abc");
//        user16.setRole("passenger");
//        user16.setUserId(1);
//        user16.setUsername("manish");
//        
//        Mockito.when(repository.findByEmailId("manish@cybage.com")).thenReturn(user16);
//        user16.setPassword("qwerty");
//        Mockito.when(repository.save(user16)).thenReturn(user16);
//        assertThat(service.updateUser(user16)).isEqualTo(user16);
//       
//        
//        
//
//	}
	
	@Test
	public void testGetUserById() {
		Users user13 = new Users();
        user13.setEmailId("majid@cybage.com");
        user13.setFirstName("Majid");
        user13.setLastName("Siddiqui");
        user13.setMobile("528653555");
        user13.setPassword("xyz");
        user13.setRole("passenger");
        user13.setUserId(1);
        user13.setUsername("majid");
        Mockito.when(repository.getById(1)).thenReturn(user13);
        assertThat(service.getUserById(1)).isEqualTo(user13);
	}

	@Test
	public void testDeleteById() {
		Users user13 = new Users();
        user13.setEmailId("majid@cybage.com");
        user13.setFirstName("Majid");
        user13.setLastName("Siddiqui");
        user13.setMobile("528653555");
        user13.setPassword("xyz");
        user13.setRole("passenger");
        user13.setUserId(1);
        user13.setUsername("majid");
        Mockito.when(repository.existsById(user13.getUserId())).thenReturn(false);
        assertFalse(repository.existsById(user13.getUserId()));      

	}
}
