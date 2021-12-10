package com.example.springlearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.entity.StockQuote;
import com.example.springlearn.repo.StockQuoteRepository;
import com.example.springlearn.service.StockQuoteService;

@RestController
@RequestMapping("/quotes")
public class StockQuoteController {
	
	@Autowired
	StockQuoteService stockQuoteService;
	@Autowired
	StockQuoteRepository stockQuoteRepo;
	
	@GetMapping("/addFromAPI")
	public String addStockQuote() {
		System.err.println("Add...!!");
		String stock = stockQuoteService.fetchStockQuote();
		return stock;
	}
	
	@GetMapping("/all")
	public List<StockQuote> getAllStockQuote(){
		return  stockQuoteRepo.findAll();
	}
	
	@GetMapping("/allRepeat")
	public ResponseEntity<?> getAllStockQuoteRepeat(){
		List<StockQuote> quotes =  stockQuoteRepo.findAll();
		
		return ResponseEntity.ok(quotes);
	}
	
	@PostMapping("/add")
	public StockQuote addRecord(@RequestBody StockQuote stockQuote) {
		
		StockQuote savedQuote = stockQuoteRepo.save(stockQuote);
		return savedQuote;
	}
	
	@PostMapping("/addQuotes")
	public List<StockQuote> addQuotes(@RequestBody List<StockQuote> quotes){
		stockQuoteRepo.saveAll(quotes);
		return quotes;
	}
	
	
	@GetMapping("/allDelete")
	public String deleteRecord() {
		stockQuoteRepo.deleteAll();
		return "success all delete";
	}
	
	
}
