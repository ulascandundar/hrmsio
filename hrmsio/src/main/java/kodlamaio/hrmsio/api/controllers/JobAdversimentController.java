package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdversimentAdd;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdversimentController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdversimentController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisement> getAll(@RequestParam int id){
		return this.jobAdvertisementService.findById(id);
	}
	
	@PostMapping("/add")
	public Result add(JobAdversimentAdd jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
		
	}
}
