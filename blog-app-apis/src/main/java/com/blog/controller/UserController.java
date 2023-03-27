package com.blog.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.ApiResponse;
import com.blog.payload.UserDto;
import com.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	//post the data
	
	@PostMapping("/")
	public ResponseEntity<UserDto>createUser(@Valid  @RequestBody UserDto userDto){
		
		
		UserDto createUserDto = this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//update the data
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto>updateUser(@Valid  @RequestBody UserDto userDto,@PathVariable Integer userId){
		
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		
		return ResponseEntity.ok(updatedUser);
	}
	
	
	//delete the data
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?>deleteUser(@PathVariable Integer userId){
		
		
		this.userService.deleteUser(userId);
		//return new ResponseEntity(Map.of("message","User Deleted Succesfully.."),HttpStatus.OK);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Delete SuccesFully",true),HttpStatus.OK);
	}
	
	
	//get the data
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getAllUsers(){
		
		return ResponseEntity.ok(userService.getAllUsers());
		
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto>getUserById(@PathVariable Integer userId){
		
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
	

}
