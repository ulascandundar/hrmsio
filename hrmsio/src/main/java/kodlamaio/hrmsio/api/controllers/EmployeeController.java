package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.EmployeeService;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Employee;
import kodlamaio.hrmsio.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PutMapping("/employerupdateconfirm")
    public Result EmployerUpdateConfirm(@RequestParam(name = "id") int id){
        return employeeService.EmployerUpdateConfirm(id);
    }
	
	@PostMapping("/add")
	public Result add(Employee employee) {
		return this.employeeService.add(employee);
		
	}
}
