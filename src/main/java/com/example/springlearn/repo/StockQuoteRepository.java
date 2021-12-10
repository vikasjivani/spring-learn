package com.example.springlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springlearn.entity.StockQuote;

@Repository
public interface StockQuoteRepository extends JpaRepository<StockQuote, Long>{
	
}
