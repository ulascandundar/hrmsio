package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.business.abstracts.UserService;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsio.dataAccess.abstracts.ImageDao;
import kodlamaio.hrmsio.dataAccess.abstracts.UserDao;
import kodlamaio.hrmsio.entities.concretes.Image;
import kodlamaio.hrmsio.entities.concretes.User;
import kodlamaio.hrmsio.entities.dtos.UserLoginDto;
import kodlamaio.hrmsio.entities.dtos.UserLoginReturnDto;
@Service
public class UserManager implements UserService{

	private UserDao userDao;
	private CandidateDao candidateDao;
    private EmployerDao employerDao;
    private EmployeeDao employeeDao;
    private ImageDao imageDao;
	@Autowired
	public UserManager(UserDao userDao,CandidateDao candidateDao,EmployerDao employerDao,EmployeeDao employeeDao,ImageDao imageDao) {
		super();
		this.userDao = userDao;
		this.candidateDao=candidateDao;
		this.employerDao=employerDao;
		this.employeeDao=employeeDao;
		this.imageDao=imageDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
		User user = this.userDao.findByEmail(userLoginDto.getEmail());
		if(user==null){
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı email girdiniz");
        }else if(!user.getPassword().equals(userLoginDto.getPassword())){
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı şifre girdiniz");
        }
		UserLoginReturnDto userLoginReturnDto = new UserLoginReturnDto();
		userLoginReturnDto.setId(user.getId());
		userLoginReturnDto.setEmail(user.getEmail());
        
		if(this.candidateDao.existsById(user.getId())){
            userLoginReturnDto.setUserType(1);
            userLoginReturnDto.setName(this.candidateDao.getById(user.getId()).getFirst_name()+" "+this.candidateDao.getById(user.getId()).getLast_name());
            List<Image> images=this.imageDao.findByUserId(user.getId());
            userLoginReturnDto.setImageLink(images.get(0).getImagePath());
        }else if(this.employerDao.existsById(user.getId())){
            userLoginReturnDto.setUserType(2);
            userLoginReturnDto.setName(this.employerDao.getById(user.getId()).getCompanyName());
        }else if(this.employeeDao.existsById(user.getId())){
            userLoginReturnDto.setUserType(3);
            userLoginReturnDto.setName(this.employeeDao.getById(user.getId()).getFirst_name()+" "+this.employeeDao.getById(user.getId()).getLast_name());
        }else {
            return new ErrorDataResult<UserLoginReturnDto>("Bir hata oluştu");
        }
		
		return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto,"Giriş yapıldı");
	}

}
