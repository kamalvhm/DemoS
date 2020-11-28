package com.acrossPart;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateAndTime {

	public static void main(String[] args) {
		ZonedDateTime fromZdt = ZonedDateTime.parse("2016-01-05T08:20:10+05:30[Asia/Kolkata]");
		//last days of months
		LocalDate lastDayofMonthGivenDate = fromZdt.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
		if((fromZdt.toLocalDate().equals(lastDayofMonthGivenDate) || fromZdt.toLocalDate().equals(lastDayofMonthGivenDate.minusDays(1)) ||
				fromZdt.toLocalDate().equals(lastDayofMonthGivenDate.minusDays(2)))) {
			
		}
		//conversion from zoned to date 
        Date cdate = Date.from(fromZdt.withZoneSameLocal(ZoneId.systemDefault()).toInstant());

	}

}
