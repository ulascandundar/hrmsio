package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.CityService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

	private CityService cityService;
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
