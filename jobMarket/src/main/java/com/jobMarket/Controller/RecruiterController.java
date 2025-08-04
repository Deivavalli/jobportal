package com.jobMarket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobMarket.DTO.RecruiterDTO;
import com.jobMarket.Entity.Recruiter;
import com.jobMarket.Service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;

	@PostMapping("/profile/{recruiterEmail}")
	public ResponseEntity<Recruiter> getRecruiterByEmail(@PathVariable String recruiterEmail,
			@RequestBody RecruiterDTO dto) {
		return ResponseEntity.ok(recruiterService.createOrRecruiterProfile(recruiterEmail, dto));

	}

	@GetMapping("/profile/{companyName}")
	public ResponseEntity<Recruiter> getRecruiterByCompanyName(@PathVariable String companyName) {
		return ResponseEntity.ok(recruiterService.getRecruiterByCompanyName(companyName));
	}

}
