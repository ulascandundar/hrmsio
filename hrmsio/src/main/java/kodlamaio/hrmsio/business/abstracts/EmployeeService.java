package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.Employee;
import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;

public interface EmployeeService {
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
	Result EmployerUpdateConfirm(int employerUpdateId);
}
