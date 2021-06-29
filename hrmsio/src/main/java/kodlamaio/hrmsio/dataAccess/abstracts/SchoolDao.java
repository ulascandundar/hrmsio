package kodlamaio.hrmsio.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsio.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

	List<School> findByUserId(int userId);
}
