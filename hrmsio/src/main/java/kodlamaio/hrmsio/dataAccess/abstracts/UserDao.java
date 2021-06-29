package kodlamaio.hrmsio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsio.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
