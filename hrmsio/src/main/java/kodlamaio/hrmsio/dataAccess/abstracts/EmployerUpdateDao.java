package kodlamaio.hrmsio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.istack.NotNull;

import kodlamaio.hrmsio.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{

	EmployerUpdate getByEmployer_Id(@NotNull int employer_id);
}
