package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


	@Query(value = "SELECT * FROM Users WHERE email=?1 and password=?2", nativeQuery = true)
	Users checkLogin(String email, String password);

	@Query(value = "INSERT INTO users (id, name, email, role, password) VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	Users addUser(int id, String name, String email, String role, String password);

	@Query(value = "Select Count(*) from users", nativeQuery = true)
	int getCount();
	
}

