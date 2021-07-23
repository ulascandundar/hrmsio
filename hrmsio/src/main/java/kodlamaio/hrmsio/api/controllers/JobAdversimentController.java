package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdversimentAdd;
import kodlamaio.hrmsio.entities.dtos.JobAdvertFilterOption;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
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
	public Result add(@Validated @RequestBody JobAdversimentAdd jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
		
	}
	
	@GetMapping("/getAllByActivationStatusFalse")
	public DataResult<List<JobAdvertisement>> getAllByActivationStatusFalse(){
		return this.jobAdvertisementService.getAllByActivationStatusFalse();
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/getAllByFilteredAndPaged")
	public DataResult<List<JobAdvertisement>> getAllByFilteredAndPaged(@RequestParam int pageNo, @RequestParam int pageSize, @RequestBody JobAdvertFilterOption filterOption) {
		return this.jobAdvertisementService.getAllByFilteredAndPaged(pageNo, pageSize, filterOption);
	}
	
	@PutMapping("/activate")
	Result activate(@RequestParam("id") int id, @RequestParam("activationStatus") boolean activationStatus) {
		return this.jobAdvertisementService.activate(id, activationStatus);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobAdvertisementService.delete(id);
	}
}
