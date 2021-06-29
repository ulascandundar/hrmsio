package kodlamaio.hrmsio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsio.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer>{

	WorkTime findById(int id);
}
