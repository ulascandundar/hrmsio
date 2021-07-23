package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.business.abstracts.EmployerUpdateService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsio.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;
import kodlamaio.hrmsio.entities.dtos.EmployerUpdateAdd;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{
	private EmployerUpdateDao employerUpdateDao;
	private EmployerDao employerDao;
    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao,EmployerDao employerDao) {
        this.employerUpdateDao = employerUpdateDao;
        this.employerDao=employerDao;
    }

    @Override
    public Result add(EmployerUpdateAdd employerUpdate) {
    	EmployerUpdate employerUpdate2= new EmployerUpdate();
    	employerUpdate2.setCompanyName(employerUpdate.getCompanyName());
    	employerUpdate2.setWebSite(employerUpdate.getWebSite());
    	employerUpdate2.setPhoneNumber(employerUpdate.getPhoneNumber());
    	employerUpdate2.setEmail(employerUpdate.getEmail());
    	employerUpdate2.setPassword(employerUpdate.getPassword());
    	employerUpdate2.setEmployer(employerDao.getById(employerUpdate.getEmployer_id()));
        employerUpdateDao.save(employerUpdate2);
        return new SuccessResult("eklendi");
    }

    @Override
    public Result delete(int id) {
        var employerUpdate = employerUpdateDao.getById(id);
        employerUpdateDao.delete(employerUpdate);
        return new SuccessResult("silindi");
    }

    @Override
    public DataResult<EmployerUpdate> getByEmployer_Id(int employerId) {
        return new SuccessDataResult<>(employerUpdateDao.getByEmployer_Id(employerId));
    }

    @Override
    public DataResult<List<EmployerUpdate>> getAll() {
        return new SuccessDataResult<>(employerUpdateDao.findAll());
    }
}
