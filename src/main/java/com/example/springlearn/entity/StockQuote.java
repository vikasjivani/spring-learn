package com.example.springlearn.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockQuote {
	
	@Id 
	@GeneratedValue
	private Long id;
	private String symbole;
	private String open;
	private String high;
	private String low;
	private String prise;
	private String volume;
	private String lastTradeDay;
	private String previousClose;
	private String change;
	private String changePercentage;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSymbole() {
		return symbole;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getPrise() {
		return prise;
	}
	public void setPrise(String prise) {
		this.prise = prise;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getLastTradeDay() {
		return lastTradeDay;
	}
	public void setLastTradeDay(String lastTradeDay) {
		this.lastTradeDay = lastTradeDay;
	}
	public String getPreviousClose() {
		return previousClose;
	}
	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getChangePercentage() {
		return changePercentage;
	}
	public void setChangePercentage(String changePercentage) {
		this.changePercentage = changePercentage;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof StockQuote)) return false;

		final StockQuote other = (StockQuote) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return getId() + " - " + getSymbole();
	}
}
