package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.User;
import kodlamaio.hrmsio.entities.dtos.UserLoginDto;
import kodlamaio.hrmsio.entities.dtos.UserLoginReturnDto;

public interface UserService {

	DataResult<List<User>> getAll();
	Result add(User user);
	DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
}
