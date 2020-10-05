package com.aggrbykey;

import java.io.Serializable;
import java.util.Date;

public class CallData implements Comparable<CallData>, Serializable {

	private static final long serialVersionUID = 232323;

	private double octets;

	private int status;

	private Date input_date;

	public CallData(double octets, int status, Date input_date) {
		super();
		this.octets = octets;
		this.status = status;
		this.input_date = input_date;
	}

	public double getOctets() {
		return octets;
	}

	public void setOctets(double octets) {
		this.octets = octets;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}

	@Override
	public int compareTo(CallData data) {

		if (this.getInput_date().compareTo(data.getInput_date()) < 0) {
			return -1;
		} else if (this.getInput_date().compareTo(data.getInput_date()) > 0) {
			return 1;
		} else if (this.getInput_date().compareTo(data.getInput_date()) == 0) {

			return Double.compare(this.getOctets(), data.getOctets());

		}

		return -1;
	}

}