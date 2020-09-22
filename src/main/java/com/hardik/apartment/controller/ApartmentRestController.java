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
import com.hardik.apartment.model.Unit;
import com.hardik.apartment.repository.UnitRepository;


// croosOrigin is required when we uploaded on heroku
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
	  
	  	@GetMapping("/units/{id}")
	    public ResponseEntity<Unit> getUnitById1(@PathVariable(value = "id") Long unitId)
	     throws ResourceNotFoundException {
	     Unit unit = unitRepository.findById(unitId)
	     .orElseThrow(() -> new ResourceNotFoundException("Unit not found for this id :: " + unitId));
	     return ResponseEntity.ok().body(unit);
	    }
	    
	  // save Unit
	    
	    @PostMapping("/units")
		 public Unit createUnit(@Validated @RequestBody Unit unit) {
	    	
		    return unitRepository.save(unit);
		    	 
		 }
	   
	    
	//Delete Unit
	    
	@DeleteMapping("/units/{id}")
		void deleteUnit(@PathVariable Long id) {
			
			unitRepository.deleteById(id);
			    
		}
	  
	 //Save Employee by ID 
	  
	    @PostMapping("/units/{id}")
	    Unit createOrSaveUnit(@RequestBody Unit newUnit) {
		  
	  	return this.unitRepository.save(newUnit);  
		  	
	  }
	  
	 // Update employee by PUT method
	 
	 @PutMapping("/units/{id}")
	 Unit updateUnit(@RequestBody Unit newUnit, @PathVariable Long id) {
	//
	      return unitRepository.findById(id).map(unit -> {
	          unit.setUnit_number(newUnit.getUnit_number());
	          unit.setUnit_type(newUnit.getUnit_type());
	          unit.setUnit_availability(newUnit.getUnit_availability());
	          return unitRepository.save(unit);
	      }).orElseGet(() -> {
          newUnit.setId(id);
	          return unitRepository.save(newUnit);
	      });
	  }
	  

}
