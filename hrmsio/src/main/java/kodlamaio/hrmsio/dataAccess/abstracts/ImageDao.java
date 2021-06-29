package kodlamaio.hrmsio.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsio.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	List<Image> findByUserId(int userId);
}
