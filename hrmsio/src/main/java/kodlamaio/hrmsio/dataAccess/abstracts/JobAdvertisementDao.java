package kodlamaio.hrmsio.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrmsio.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsio.entities.dtos.JobAdvertFilterOption;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	JobAdvertisement findById(int id);
	
	List<JobAdvertisement> getAllByIsActiveTrue();
	
	@Query("From JobAdvertisement where isActive = true and employer.id = :id order by expiration_date asc")
	List<JobAdvertisement> getAllByEmployerId(int id);
	
	@Query("From JobAdvertisement where isActive = false order by applicationDeadline asc")
	List<JobAdvertisement> getAllByActivationStatusFalse();
	
	@Query("Select j from JobAdvertisement j where isActive = true and ((:#{#filter.city_id}) IS NULL OR j.city.id IN (:#{#filter.city_id}))"
			+ "and ((:#{#filter.jobposition_id}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobposition_id}))"
			+ "and ((:#{#filter.time_id}) IS NULL OR j.workTime.id IN (:#{#filter.time_id}))")
	public Page<JobAdvertisement> getFilteringAndPage(@Param("filter") JobAdvertFilterOption filterOption, Pageable pageable);
}
