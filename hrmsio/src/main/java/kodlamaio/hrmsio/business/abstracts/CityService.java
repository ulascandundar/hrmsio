package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.City;

public interface CityService {

	Result add(City city);
	DataResult<List<City>> getAll();
	DataResult<City>findById(int id);
}
