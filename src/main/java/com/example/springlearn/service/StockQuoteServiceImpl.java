package com.example.springlearn.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springlearn.entity.StockQuote;
import com.example.springlearn.repo.StockQuoteRepository;
//import org.json.JSONObject;

@Service
public class StockQuoteServiceImpl implements StockQuoteService{
	
	@Autowired
	StockQuoteRepository stockQuoteRepo;
	CloseableHttpClient httpClient = HttpClients.createDefault();
	  
	public String fetchStockQuote() {
		System.err.println("hello");
//		HttpGet httpRequest =
//		          new HttpGet(
//		              "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=demo");
//		
//		try (CloseableHttpResponse httpRresponse = httpClient.execute(httpRequest)) {
//	        HttpEntity entity = httpRresponse.getEntity();
//
//	        if (entity != null) {
//	          StockQuote stockQuote = new StockQuote();
//	          
//	          String result = EntityUtils.toString(entity);
//	          System.err.println(result);
//	          
//              JSONObject jsonObj = new JSONObject(result);
//              JSONObject jsonObjData = (JSONObject) jsonObj.get("Global Quote");
//              System.err.println(jsonObjData);
//              
//              stockQuote.setSymbole(jsonObjData.get("01. symbol").toString());
//              stockQuote.setOpen(jsonObjData.get("02. open").toString());
//              stockQuote.setHigh(jsonObjData.get("03. high").toString());
//              stockQuote.setLow(jsonObjData.get("04. low").toString());
//              stockQuote.setPrise(jsonObjData.get("05. price").toString());
//              stockQuote.setVolume(jsonObjData.get("06. volume").toString());
//              stockQuote.setLastTradeDay(jsonObjData.get("07. latest trading day").toString());
//              stockQuote.setPreviousClose(jsonObjData.get("08. previous close").toString());
//              stockQuote.setChange(jsonObjData.get("09. change").toString());
//              stockQuote.setChangePercentage(jsonObjData.get("10. change percent").toString());
//              
//             stockQuote =  stockQuoteRepo.save(stockQuote);
//             return stockQuote.toString();
//	        }
//	      } catch (Exception e) {
//	        System.err.println("exception");
//	      }
		
		return "API - Error";
	}
}
