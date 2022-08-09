package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


	@Query(value = "SELECT * FROM Users WHERE email=?1 and password=?2", nativeQuery = true)
	void checkLogin(String email, String password);

	@Query(value = "INSERT INTO Users VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	void addUser(int id, String name, String email, String role, String password);
	
}

