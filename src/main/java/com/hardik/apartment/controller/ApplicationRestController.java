package com.hardik.apartment.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	   
	    
   //Delete Application
	   
	    @DeleteMapping("/applications/{id}")
	    void deleteApplication(@PathVariable Long id) {
			
			applicationRepository.deleteById(id);
			    
		}
	 
	//Save Application by ID 
	 
	  @PostMapping("/applications/{id}")
	  Application createOrSaveEmployee(@RequestBody Application newApplication) {
		  
		  	return this.applicationRepository.save(newApplication);  
		  	
	  }
	 
	// Update employee by PUT method
	 
	  @PutMapping("/applications/{id}")
	  	Application updateApplication(@RequestBody Application newApplication, @PathVariable Long id) {
	
	    return applicationRepository.findById(id).map(application -> {
	          application.setFirstName(newApplication.getFirstName());
          application.setLastName(newApplication.getLastName());
	          application.setEmail(newApplication.getEmail());
	          application.setPhone(newApplication.getPhone());
	          application.setApartmentType(newApplication.getApartmentType());
	          application.setStartingDate(newApplication.getStartingDate());
	          application.setLeaseDuration(newApplication.getLeaseDuration());
	          application.setNumberOfResident(newApplication.getNumberOfResident());
	          application.setOccupation(newApplication.getOccupation());          
	          return applicationRepository.save(application);
	      }).orElseGet(() -> {
	          newApplication.setId(id);
	          return applicationRepository.save(newApplication);
      });
	  }

}

