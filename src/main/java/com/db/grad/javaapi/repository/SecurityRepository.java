package com.db.grad.javaapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {

	List<Security> getAllByStatus(String status);
	
	@Query(value = "SELECT * FROM Security WHERE maturity_date BETWEEN ?1 AND ?2", nativeQuery = true)
	public List<Security> getSecurityByMaturityDate(LocalDate localDate1, LocalDate localDate2);
	
	@Query(value = " SELECT security.id, security.isin,security.cusip, security.issuer, security.maturity_date, security.coupon, "
			+ "security.type, security.facevalue, security.status, security.action, security.issue FROM Security, "
			+ "trade, book, book_user, users WHERE Security.id=Trade.security_id AND Trade.Book_Id=Book.id AND Book.id=Book_User.Book_Id AND Book_User.user_id=?1", nativeQuery = true)
	public List<Security> getSecurityByUserId(Long userId);
	
}