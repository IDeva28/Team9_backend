package com.db.grad.javaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{
	@Query(value = "select * from trade where book_id = :book_id", nativeQuery = true)
	List<Trade> getAllByBookId(long book_id);
}
