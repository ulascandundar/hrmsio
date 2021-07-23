package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;
import kodlamaio.hrmsio.entities.dtos.EmployerUpdateAdd;

public interface EmployerUpdateService {

	Result add(EmployerUpdateAdd employerUpdateAdd);
    Result delete(int id);
    DataResult<EmployerUpdate> getByEmployer_Id(int employerId);
    DataResult<List<EmployerUpdate>> getAll();
}
