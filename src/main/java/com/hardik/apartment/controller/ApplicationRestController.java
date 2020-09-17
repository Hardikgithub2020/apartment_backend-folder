package com.hardik.apartment.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.apartment.exception.ResourceNotFoundException;
import com.hardik.apartment.model.Application;

import com.hardik.apartment.repository.ApplicationRepository;




@CrossOrigin 
@RestController
@RequestMapping(value = "/application_api/v1")
public class ApplicationRestController {
	 
	@Autowired
	  private ApplicationRepository applicationRepository;
	  
	  //GET ALL Application INFO
	  
	  @GetMapping("/applications")
	  public List<Application> getAllApplication(Model model) {
	    return this.applicationRepository.findAll();
	  }
	  
	  // Get employee by id
	  
	  	@GetMapping("/applications/{id}")
	    public ResponseEntity<Application> getApplicationById1(@PathVariable(value = "id") Long applicationId)
	     throws ResourceNotFoundException {
	     Application application = applicationRepository.findById(applicationId)
	     .orElseThrow(() -> new ResourceNotFoundException("Application not found for this id :: " + applicationId));
	     return ResponseEntity.ok().body(application);
	    }
	    
	  // save employee
	    
	    @PostMapping("/applications")
		 public Application createApplication(@Validated @RequestBody Application application) {
	    	
		    return applicationRepository.save(application);
		    	 
		 }
	   
	    
	//  //Delete Employee
	//    
//		@DeleteMapping("/employees/{id}")
//		void deleteEmployee(@PathVariable Long id) {
//			
//			employeeRepository.deleteById(id);
//			    
//		}
	//  
	//  //Save Employee by ID 
	//  
	//  @PostMapping("/employees/{id}")
	//  Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
//		  
//		  	return this.employeeRepository.save(newEmployee);  
//		  	
	//  }
	//  
	//  // Update employee by PUT method
	//  
	//  @PutMapping("/employees/{id}")
	//  Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
	//
//	      return employeeRepository.findById(id).map(employee -> {
//	          employee.setFirstName(newEmployee.getFirstName());
//	          employee.setLastName(newEmployee.getLastName());
//	          employee.setEmail(newEmployee.getEmail());
//	          return employeeRepository.save(employee);
//	      }).orElseGet(() -> {
//	          newEmployee.setId(id);
//	          return employeeRepository.save(newEmployee);
//	      });
	//  }

}

