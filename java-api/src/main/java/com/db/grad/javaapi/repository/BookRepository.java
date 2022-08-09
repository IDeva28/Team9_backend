package com.db.grad.javaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	@Query(value = "select * from book where id in (select b.book_id from book_user where b.user_id = :user_id)", nativeQuery =  true)
	List<Book> getAllBooksByUserId(long user_id);

}
