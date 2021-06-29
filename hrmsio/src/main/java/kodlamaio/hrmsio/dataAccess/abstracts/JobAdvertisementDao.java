package kodlamaio.hrmsio.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	JobAdvertisement findById(int id);
	
	List<JobAdvertisement> getAllByIsActiveTrue();
	
	@Query("From JobAdvertisement where isActive = true and employer.id = :id order by expiration_date asc")
	List<JobAdvertisement> getAllByEmployerId(int id);
}
