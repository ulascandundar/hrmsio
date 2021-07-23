package kodlamaio.hrmsio.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.EmployerUpdateService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;
import kodlamaio.hrmsio.entities.dtos.EmployerUpdateAdd;

@RestController
@RequestMapping("/api/employerUpdate/")
@CrossOrigin
public class EmployersUpdateController {
    private EmployerUpdateService employerUpdateService;
    @Autowired
    public EmployersUpdateController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("getAll")
    public DataResult<List<EmployerUpdate>> getAll(){
        return employerUpdateService.getAll();
    }
    
    @PostMapping("add")
    public Result add(@Validated @RequestBody EmployerUpdateAdd employerUpdateAdd){
        return employerUpdateService.add(employerUpdateAdd);
    }

    @GetMapping("getByEmployerId")
    public DataResult<EmployerUpdate> getByEmployerId(@RequestParam int employerId){
        return employerUpdateService.getByEmployer_Id(employerId);
    }
    @DeleteMapping("delete")
    public Result delete(@RequestParam int id){
        return employerUpdateService.delete(id);
    }
    //
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "Doğrulama hataları");
    }
}
