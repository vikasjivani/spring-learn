package com.example.springlearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.entity.Ncdex;
import com.example.springlearn.repo.NcdexRepository;

@RestController
@RequestMapping("/ncdex")
public class NcdexController {
	

	@Autowired
	NcdexRepository ncdexRepo;
	
	
	@GetMapping("/all")
	public List<Ncdex> getAllStockQuote(){
		return  ncdexRepo.findAll();
	}
	
	@GetMapping("/allRepeat")
	public ResponseEntity<?> getAllStockQuoteRepeat(){
		List<Ncdex> quotes =  ncdexRepo.findAll();
		
		return ResponseEntity.ok(quotes);
	}
	
	@PostMapping("/add")
	public Ncdex addRecord(@RequestBody Ncdex ncdex) {
		
		Ncdex savedQuote = ncdexRepo.save(ncdex);
		return savedQuote;
	}
	
	@PostMapping("/addQuotes")
	public List<Ncdex> addQuotes(@RequestBody List<Ncdex> quotes){
		ncdexRepo.saveAll(quotes);
		return quotes;
	}
	
	
	@GetMapping("/allDelete")
	public String deleteRecord() {
		ncdexRepo.deleteAll();
		return "success all delete";
	}
	
	
}
