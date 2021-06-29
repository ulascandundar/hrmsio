package kodlamaio.hrmsio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsio.business.abstracts.CityService;
import kodlamaio.hrmsio.business.abstracts.EmployerService;
import kodlamaio.hrmsio.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsio.business.abstracts.JobPositionService;
import kodlamaio.hrmsio.business.abstracts.WorkTimeService;
import kodlamaio.hrmsio.core.utilities.results.DataResult;
import kodlamaio.hrmsio.core.utilities.results.Result;
import kodlamaio.hrmsio.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsio.core.utilities.results.SuccessResult;
import kodlamaio.hrmsio.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdversimentAdd;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	private WorkTimeService workTimeService;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,CityService cityService,JobPositionService jobPositionService,EmployerService employerService,WorkTimeService workTimeService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService=cityService;
		this.jobPositionService=jobPositionService;
		this.employerService=employerService;
		this.workTimeService=workTimeService;
	}

	@Override
	public Result add(JobAdversimentAdd jobAdvertisementA) {
		JobAdvertisement jobad=new JobAdvertisement(0,
				jobAdvertisementA.getJobDescription(),
				jobAdvertisementA.getMinSalary(),
				jobAdvertisementA.getMaxSalary(),
				jobAdvertisementA.getNumberOfOpenPositions(),
				jobAdvertisementA.getApplicationDeadline(),
				jobAdvertisementA.getPostedDate(),
				false,
				this.employerService.findById(jobAdvertisementA.getEmployer_id()).getData(),
				this.workTimeService.findById(jobAdvertisementA.getTime_id()).getData(),
				this.jobPositionService.findById(jobAdvertisementA.getJobposition_id()).getData(),
				this.cityService.findById(jobAdvertisementA.getCity_id()).getData());
		
		this.jobAdvertisementDao.save(jobad);
		return new SuccessResult();
	}



	@Override
	public DataResult<JobAdvertisement> findById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id));
	}



}
