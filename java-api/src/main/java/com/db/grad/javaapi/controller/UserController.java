package com.db.grad.javaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.TradeRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
    private TradeRepository tradeRepository;
	
	@Autowired
    private BookRepository bookRepository;	
	
	
	@GetMapping("/{user_id}/book")
	public ResponseEntity < List<Book> > getAllBooksByUserId(@PathVariable(value = "user_id") Long user_id)
	throws ResourceNotFoundException {
		List<Book> book = bookRepository.getAllBooksByUserId(user_id);
		return ResponseEntity.ok().body(book);
	}
	
	
	@GetMapping("/user/{book_id}/trade")
	public ResponseEntity < List<Trade> > getAllTradesByBookId (@PathVariable(value = "book_id") Long book_id)
	throws ResourceNotFoundException {
		List<Trade> trade = tradeRepository.getAllByBookId(book_id);
		return ResponseEntity.ok().body(trade);
	}
	
	
}
