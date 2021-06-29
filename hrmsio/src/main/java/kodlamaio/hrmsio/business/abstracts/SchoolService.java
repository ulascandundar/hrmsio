package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getByUserId(int userId);
}
