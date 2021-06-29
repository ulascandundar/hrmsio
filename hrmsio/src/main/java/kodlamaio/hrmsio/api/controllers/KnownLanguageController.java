package kodlamaio.hrmsio.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.KnownLanguage;
import kodlamaio.hrmsio.business.abstracts.KnownLanguageService;

@RestController
@RequestMapping("/api/lang")
@CrossOrigin
public class KnownLanguageController {

	private KnownLanguageService knownLanguageService;

	@Autowired
	public KnownLanguageController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<KnownLanguage>> getAll(){
		return this.knownLanguageService.getAll();
	}
	@GetMapping("/getById")
	public DataResult<List<KnownLanguage>> getById(@RequestParam int id){
		return this.knownLanguageService.getByUserId(id);
	}
	
	@PostMapping("/add")
	public Result add( @RequestBody KnownLanguage knownLanguage) {
		return this.knownLanguageService.add(knownLanguage);
		
	}
}
