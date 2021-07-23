package kodlamaio.hrmsio.business.abstracts;

import java.util.List;

import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdversimentAdd;
import kodlamaio.hrmsio.entities.dtos.JobAdvertFilterOption;

public interface JobAdvertisementService {

	Result add(JobAdversimentAdd jobAdvertisementA);
	
	DataResult<JobAdvertisement> findById(int id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllByFilteredAndPaged(int pageNo, int pageSize, JobAdvertFilterOption filterOption);
	DataResult<List<JobAdvertisement>> getAllByActivationStatusFalse();
	Result delete(int id);
	Result activate(int id, boolean activationStatus);
}
