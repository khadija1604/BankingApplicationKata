package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.DateGenerator;

public class DateGeneratorTest {
	private DateGenerator dateGenerator;
	
	@BeforeEach
	void init() {
		dateGenerator= new dateGeneratorForTest();
	}
	
	@Test
	void dateGenerator_getDateString() {
		assertEquals("07/01/2021", dateGenerator.getDateString());
	}
	
	private class dateGeneratorForTest extends DateGenerator{
		protected LocalDate getToday() {
			return LocalDate.of(2021, 1, 7);
		}
		
	}

}
