package com.personaadhaar;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AadhaarController {
	
	 @Autowired
	    AadhaarRepo aadhaarRepo;

	    // Insert Aadhaar
	    // http://localhost:8080/saveAadhaar
	    // {
	    //   "anum": "123456789012",
	    //   "address": "Delhi"
	    // }
	    @PostMapping("/saveAadhaar")
	    public String saveAadhaar(@RequestBody Aadhaar aadhaar) {
	        aadhaarRepo.save(aadhaar);
	        return "Aadhaar Saved Successfully!";
	    }

	    // Update Aadhaar
	    // http://localhost:8080/updateAadhaar
	    @PutMapping("/updateAadhaar")
	    public String updateAadhaar(@RequestBody Aadhaar aadhaar) {
	        aadhaarRepo.save(aadhaar);
	        return "Aadhaar Updated Successfully!";
	    }

	    // Delete Aadhaar
	    // http://localhost:8080/deleteAadhaar/1
	    @DeleteMapping("/deleteAadhaar/{id}")
	    public String deleteAadhaar(@PathVariable Long id) {
	        aadhaarRepo.deleteById(id);
	        return "Aadhaar Deleted Successfully!";
	    }

	    // Find Aadhaar by ID
	    // http://localhost:8080/findAadhaar/1
	    @GetMapping("/findAadhaar/{id}")
	    public String findAadhaar(@PathVariable Long id) {
	        Optional<Aadhaar> ad = aadhaarRepo.findById(id);
	        if (ad.isPresent()) {
	            Aadhaar a = ad.get();
	            return "Aadhaar Found: " + a.getAnum() + ", Address: " + a.getAddress();
	        } else {
	            return "Aadhaar Not Found!";
	        }
	    }

	    // Fetch All Aadhaar Records
	    // http://localhost:8080/fetchAllAadhaar
	    @GetMapping("/fetchAllAadhaar")
	    public List<Aadhaar> fetchAllAadhaar() {
	        return aadhaarRepo.findAll();
	    }

}
