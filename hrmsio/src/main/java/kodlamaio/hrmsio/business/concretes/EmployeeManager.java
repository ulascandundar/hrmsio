package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.business.abstracts.EmployeeService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrmsio.entities.concretes.Employee;
import kodlamaio.hrmsio.entities.concretes.Employer;
import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao emloyeeDao;
	private EmployerDao employerDao;
	private EmployerUpdateDao employerUpdateDao;
	@Autowired
	public EmployeeManager(EmployeeDao emloyeeDao, EmployerDao employerDao, EmployerUpdateDao employerUpdateDao) {
		super();
		this.emloyeeDao = emloyeeDao;
		this.employerDao = employerDao;
		this.employerUpdateDao = employerUpdateDao;
	}

	@Override
	public Result add(Employee employee) {
		this.emloyeeDao.save(employee);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.emloyeeDao.findAll());
	}

	@Override
	public Result EmployerUpdateConfirm(int employerUpdateId) {
		EmployerUpdate employerUpdate2=this.employerUpdateDao.getById(employerUpdateId);
		Employer employer= new Employer();
		employer.setId(employerUpdate2.getEmployer().getId());
		employer.setEmail(employerUpdate2.getEmail());
		employer.setPassword(employerUpdate2.getPassword());
		employer.setCompanyName(employerUpdate2.getCompanyName());
		employer.setWebSite(employerUpdate2.getWebSite());
		employer.setPhoneNumber(employerUpdate2.getPhoneNumber());
		this.employerDao.save(employer);
		employerUpdateDao.deleteById(employerUpdateId);
		return new SuccessResult("değişim onaylandı");
	}

}
