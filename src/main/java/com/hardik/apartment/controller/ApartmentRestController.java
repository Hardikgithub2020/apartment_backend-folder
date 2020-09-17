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
import com.hardik.apartment.model.Unit;
import com.hardik.apartment.repository.UnitRepository;



@CrossOrigin
@RestController
@RequestMapping(value = "/hardik/apartment/api/v1")
public class ApartmentRestController {
	 
	@Autowired
	  private UnitRepository unitRepository;
	  
	  //GET ALL UNIT INFO
	  
	  @GetMapping("/units")
	  public List<Unit> getAllUnit(Model model) {
	    return this.unitRepository.findAll();
	  }
	  
	  // Get employee by id
	  
	  	@GetMapping("/unit/{id}")
	    public ResponseEntity<Unit> getUnitById1(@PathVariable(value = "id") Long unitId)
	     throws ResourceNotFoundException {
	     Unit unit = unitRepository.findById(unitId)
	     .orElseThrow(() -> new ResourceNotFoundException("Unit not found for this id :: " + unitId));
	     return ResponseEntity.ok().body(unit);
	    }
	    
	  // save employee
	    
	    @PostMapping("/unit")
		 public Unit createUnit(@Validated @RequestBody Unit unit) {
	    	
		    return unitRepository.save(unit);
		    	 
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
