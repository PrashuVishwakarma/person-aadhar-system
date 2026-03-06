package com.personaadhaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepo personRepo;

    @Autowired
    AadhaarRepo aadhaarRepo;

    // Insert Person with Aadhaar ID
    // http://localhost:8080/savePerson/1
    @PostMapping("/savePerson/{aadhaarId}")
    public String savePerson(@RequestBody Person person, @PathVariable Long aadhaarId) {
        Optional<Aadhaar> ad = aadhaarRepo.findById(aadhaarId);
        if (ad.isPresent()) {
            person.setAadhaar(ad.get());
            personRepo.save(person);
            return "Person Saved Successfully!";
        } else {
            return "Aadhaar not found for ID: " + aadhaarId;
        }
    }

    // Update Person
    // http://localhost:8080/updatePerson
    @PutMapping("/updatePerson")
    public String updatePerson(@RequestBody Person person) {
        personRepo.save(person);
        return "Person Updated Successfully!";
    }

    // Delete Person by ID
    // http://localhost:8080/deletePerson/1
    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepo.deleteById(id);
        return "Person Deleted Successfully!";
    }

    // Find Person by ID
    // http://localhost:8080/findPerson/1
    @GetMapping("/findPerson/{id}")
    public String findPerson(@PathVariable Long id) {
        Optional<Person> p = personRepo.findById(id);
        if (p.isPresent()) {
            Person person = p.get();
            return "Person Found: " + person.getName();
        } else {
            return "Person Not Found!";
        }
    }

    // Fetch All Persons
    // http://localhost:8080/fetchAllPersons
    @GetMapping("/fetchAllPersons")
    public List<Person> fetchAllPersons() {
        return personRepo.findAll();
    }
	

}
