package com.beans;

import java.io.Serializable;
import java.util.Date;

public class Weather implements Serializable{
	  	private int temp;
	    private int id;
		private Date date;
	  	//private int temp_centi;

		
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		/*public int getTemp_centi() {
			return temp_centi;
		}
		public void setTemp_centi(int temp_centi) {
			this.temp_centi = temp_centi;
		}*/
		public void setDate(Date date) {
			this.date = date;
		}
		
		@Override
		public String toString() {
			return "Weather [temp=" + temp + ", id=" + id + ", date=" + date + "]";
		}
		
		
}
