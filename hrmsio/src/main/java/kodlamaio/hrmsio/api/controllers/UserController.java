package kodlamaio.hrmsio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsio.business.abstracts.UserService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.entities.concretes.User;
import kodlamaio.hrmsio.entities.dtos.UserLoginDto;
import kodlamaio.hrmsio.entities.dtos.UserLoginReturnDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto){
        DataResult<UserLoginReturnDto> result = this.userService.login(userLoginDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
