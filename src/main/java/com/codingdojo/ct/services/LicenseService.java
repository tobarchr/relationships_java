package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.License;
import com.codingdojo.ct.repositories.LicenseRepository;

@Service
public class LicenseService {
	 	private final LicenseRepository licenseRepository;
	    
	    public LicenseService(LicenseRepository licenseRepository) {
	        this.licenseRepository = licenseRepository;
	    }
	    // returns all the persons
	    public List<License> allLicenses() {
	        return licenseRepository.findAll();
	    }
	    // creates a person
	    public License createLicense(License b) {
	        return licenseRepository.save(b);
	    }
	    
	    // Updates a person
	    public License updateLicense(License b) {
	        return licenseRepository.save(b);
	    }
	    
	    // retrieves a person
	    public License findLicense(Long id) {
	        Optional<License> optionalBook = licenseRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //Deletes a person
	    
		public void deleteLicense(long id) {
			licenseRepository.deleteById(id);
		  }
}


