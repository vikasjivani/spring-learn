package com.example.springlearn.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ncdex {

		@Id
		@GeneratedValue
		private Long id;

		private String nameEn;

		private String nameHi;

		private String locationEn;

		private String locationHi;

		private String timePoll;

		private String priceTag;

		private String percentage;

		public Ncdex() {
		}

		public Ncdex(String nameEn, String nameHi) {
			this.nameEn = nameEn;
			this.nameHi = nameHi;
		}

		public Long getId() {
			return id;
		}

		
		public void setId(Long id) {
			this.id = id;
		}

		public String getNameEn() {
			return nameEn;
		}

		public void setNameEn(String nameEn) {
			this.nameEn = nameEn;
		}

		public String getNameHi() {
			return nameHi;
		}

		public void setNameHi(String nameHi) {
			this.nameHi = nameHi;
		}

		public String getLocationEn() {
			return locationEn;
		}

		public void setLocationEn(String locationEn) {
			this.locationEn = locationEn;
		}

		public String getLocationHi() {
			return locationHi;
		}

		public void setLocationHi(String locationHi) {
			this.locationHi = locationHi;
		}

		public String getTimePoll() {
			return timePoll;
		}

		public void setTimePoll(String timePoll) {
			this.timePoll = timePoll;
		}

		public String getPriceTag() {
			return priceTag;
		}

		public void setPriceTag(String priceTag) {
			this.priceTag = priceTag;
		}

		public String getPercentage() {
			return percentage;
		}

		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}

		

		@Override
		public boolean equals(Object obj) {
			if (obj == null) return false;
			if (this == obj) return true;
			if (!(obj instanceof Ncdex)) return false;

			final Ncdex other = (Ncdex) obj;
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
			return getId().toString();
		}
	}
