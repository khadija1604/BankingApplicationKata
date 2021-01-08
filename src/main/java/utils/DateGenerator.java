package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public  String getDateString() {
		LocalDate today = getToday();
		return today.format(DATE_FORMAT);
	}
	
	protected LocalDate getToday() {
		return LocalDate.now();
	}

}
