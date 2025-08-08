package com.jobMarket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobMarket.DTO.JobPostDTO;
import com.jobMarket.Service.JobPostService;

@RestController
@RequestMapping("/api/jobPost")
public class JobPostController {
	@Autowired
	private JobPostService jobPostService;

	@PostMapping
	public ResponseEntity<JobPostDTO> createJobs(@RequestBody JobPostDTO dto) {
		return ResponseEntity.ok(jobPostService.createJob(dto));
	}

	@GetMapping("search/{companyName}")
	public ResponseEntity<List<JobPostDTO>> getJobByCompanyName(@PathVariable String comapnyName) {
		return ResponseEntity.ok(jobPostService.findJobByCompanyName(comapnyName));
	}

	@GetMapping("/recruiters/{recruiterEmail}")
	public ResponseEntity<List<JobPostDTO>> getJobByrecruiterEmail(@PathVariable String recruiterEmail) {
		return ResponseEntity.ok(jobPostService.findJobByRecruiterEmail(recruiterEmail));
	}

	@GetMapping("/search/{jobTitle}")
	public ResponseEntity<List<JobPostDTO>> getJobByJobTitle(@PathVariable String jobTitle) {
		return ResponseEntity.ok(jobPostService.findJobByJobTitle(jobTitle));
	}

}
