package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.ErrorResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrmsio.entities.concretes.School;
import kodlamaio.hrmsio.business.abstracts.SchoolService;
@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<School>> getByUserId(int userId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findByUserId(userId));
	}

	@Override
	public Result deleteSchool(int schoolId) {
		if(!this.schoolDao.existsById(schoolId)){
            return new ErrorResult("Böyle bir okul yok");
        }
        this.schoolDao.deleteById(schoolId);
        return new SuccessResult("Okul silindi");
	}
}
