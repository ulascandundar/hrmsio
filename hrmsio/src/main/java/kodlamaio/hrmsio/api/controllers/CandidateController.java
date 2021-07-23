package kodlamaio.hrmsio.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsio.entities.dtos.CandidateCv;
import kodlamaio.hrmsio.business.abstracts.CandidateService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {

	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Candidate candidate) {
		return this.candidateService.add(candidate);
		
	}
	
	@PutMapping("/likejobadvertisement")
	public ResponseEntity<?> likeJobAdvertisement(@RequestParam(name = "candidateId") int candidateId,
			@RequestParam(name = "jobAdvertisementId") int jobAdvertisementId) {
		return ResponseEntity.ok(this.candidateService.likeJobAdvertisement(candidateId, jobAdvertisementId));
	}
	
	
	@PutMapping("/dislikejobadvertisement")
	public ResponseEntity<?> dislikeJobAdvertisement(@RequestParam(name = "candidateId") int candidateId,
			@RequestParam(name = "jobAdvertisementId") int jobAdvertisementId) {
		return ResponseEntity.ok(this.candidateService.dislikeJobAdvertisement(candidateId, jobAdvertisementId));
	}
	
	@GetMapping("/getallCv")
	public DataResult<List<CandidateCv>> getAllCv(){
		return candidateService.getAllCv();
	}
	
	@GetMapping("/getbyidcv")
	public DataResult<CandidateCv> getByIdCv(@RequestParam(name = "candidateId") int candidateId){
		return candidateService.getByCandidateId(candidateId);
	}
	
	@PutMapping("/updateGithub")
    public ResponseEntity<?> updateGithub(@RequestParam String githublink,@RequestParam int candidateId){
        Result result=this.candidateService.updateGithub(githublink,candidateId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/deleteGithub")
    public ResponseEntity<?> deleteGithub(@RequestParam int candidateId){
        Result result=this.candidateService.deleteGithub(candidateId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/updateLinkedin")
    public ResponseEntity<?> updateLinkedin(@RequestParam String linkedinlink,@RequestParam int candidateId){
        Result result=this.candidateService.updateLinkedin(linkedinlink,candidateId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/deleteLinkedin")
    public ResponseEntity<?> deleteLinkedin(@RequestParam int candidateId){
        Result result=this.candidateService.deleteLinkedin(candidateId);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>(validationErrors,"Validation Errors");
	}
	
	
}
