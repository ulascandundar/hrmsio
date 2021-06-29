package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.WorkTime;

public interface WorkTimeService {

	DataResult<List<WorkTime>> getAll();
	Result add(WorkTime workTime);
	DataResult<WorkTime>findById(int id);
}