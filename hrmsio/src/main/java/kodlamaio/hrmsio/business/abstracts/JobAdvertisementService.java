package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdversimentAdd;

public interface JobAdvertisementService {

	Result add(JobAdversimentAdd jobAdvertisementA);
	
	DataResult<JobAdvertisement> findById(int id);

}
