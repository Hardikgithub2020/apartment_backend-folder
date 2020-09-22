package com.hardik.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.apartment.exception.ResourceNotFoundException;
import com.hardik.apartment.model.User;
import com.hardik.apartment.repository.UserRepository;



//croosOrigin is required when we uploaded on heroku
@CrossOrigin
@RestController
@RequestMapping(value = "/hardik/users/api/v1")
public class UserRestController {
	 
	@Autowired
	  private UserRepository userRepository;
	  
	  //GET ALL UNIT INFO
	  
	  @GetMapping("/users")
	  public List<User> getAllUser(Model model) {
	    return this.userRepository.findAll();
	  }
	  
	  // Get employee by id
	  
	  	@GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById1(@PathVariable(value = "id") Long userId)
	     throws ResourceNotFoundException {
	     User user = userRepository.findById(userId)
	     .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	     return ResponseEntity.ok().body(user);
	    }
	    
	  // save Unit
	    
	    @PostMapping("/users")
		 public User createUnit(@Validated @RequestBody User user) {
	    	
		    return userRepository.save(user);
		    	 
		 }
	   
	    
	//Delete Unit
	    
	@DeleteMapping("/user/{id}")
		void deleteUnit(@PathVariable Long id) {
			
			userRepository.deleteById(id);
			    
		}
	  
	 //Save Employee by ID 
	  
	    @PostMapping("/users/{id}")
	    User createOrSaveUnit(@RequestBody User newUser) {
		  
	  	return this.userRepository.save(newUser);  
		  	
	  }
	  
	 // Update employee by PUT method
	 
	 @PutMapping("/users/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
	//
	      return userRepository.findById(id).map(user -> {
	          user.setEmail(newUser.getEmail());
	          user.setPassword(newUser.getPassword());
	          return userRepository.save(user);
	      }).orElseGet(() -> {
          newUser.setId(id);
	          return userRepository.save(newUser);
	      });
	  }
	  

}
