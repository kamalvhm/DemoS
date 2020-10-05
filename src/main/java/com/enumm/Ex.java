package com.enumm;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class Ex {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
	ZonedDateTime start = ZonedDateTime.parse("2016-01-01T08:20:10+05:30[Asia/Kolkata]");

	ZonedDateTime end = ZonedDateTime.parse("2016-01-02T08:20:10+05:30[Asia/Kolkata]");
	
	IntStream.iterate(0, i -> i + 1).limit(ChronoUnit.DAYS.between(start, end))
	.mapToObj(i -> start.plusDays(i)).forEach(r->System.out.print(r+" "));


	}

}
