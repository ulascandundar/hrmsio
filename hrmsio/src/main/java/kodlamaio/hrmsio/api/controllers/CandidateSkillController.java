package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.CandidateSkillService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.CandidateSkill;

@RestController
@RequestMapping("/api/candidateskills")
@CrossOrigin
public class CandidateSkillController {

	private CandidateSkillService candidateSkillService;

	@Autowired
	public CandidateSkillController(CandidateSkillService candidateSkillService) {
		super();
		this.candidateSkillService = candidateSkillService;
	} 
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSkill candidateSkill) {
		return this.candidateSkillService.add(candidateSkill);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSkill>> getAll(){
		return this.candidateSkillService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<List<CandidateSkill>> getById(@RequestParam int id){
		return this.candidateSkillService.getByUserId(id);
	}
	
	@DeleteMapping("/deleteSkill")
    public Result deleteSkill(@RequestParam int skillId){
        return this.candidateSkillService.deleteSkill(skillId);
    }
}
