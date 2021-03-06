package kodlamaio.hrmsio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsio.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	City findById(int id);
}
