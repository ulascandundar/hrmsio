package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.WorkTimeService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.WorkTime;

@RestController
@RequestMapping("/api/worktime")
@CrossOrigin
public class WorkTimeController {

	private WorkTimeService workTimeService;
	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkTime workTime) {
		return this.workTimeService.add(workTime);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkTime>> getAll(){
		return this.workTimeService.getAll();
	}
	
}
