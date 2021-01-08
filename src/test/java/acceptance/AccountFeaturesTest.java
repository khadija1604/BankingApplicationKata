package acceptance;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import domain.Account;
import domain.ConsolePrinter;
import domain.OperationsPrinter;
import repository.OperationRepository;
import utils.DateGenerator;

public class AccountFeaturesTest {
	private Account account;
	
	
	private ConsolePrinter consolePrinter = mock(ConsolePrinter.class);
	private DateGenerator dateGenerator = mock(DateGenerator.class);

	@BeforeEach
	void init() {
		OperationRepository operationRepository= new OperationRepository(dateGenerator);
		OperationsPrinter operationsPrinter = new OperationsPrinter(consolePrinter);
		account = new Account(operationRepository,operationsPrinter);
	}
	
	@Test
	@DisplayName("Client can check the history of all his operations")
	void shouldDisplayAllOperations() {
		when(dateGenerator.getDateString()).thenReturn("08/01/2020","08/01/2020","08/01/2020");
		account.deposit(100);
		account.deposit(50);
		account.withdraw(50);
		account.printOperationsHistory();
		  InOrder inOrder= Mockito.inOrder(consolePrinter);
		  inOrder.verify(consolePrinter).
		  printTransaction("Operation, Date, Amount, Balance");
		  inOrder.verify(consolePrinter).
		  printTransaction("Deposit, 08/01/2020, 100.0, 100.0");
		  inOrder.verify(consolePrinter).
		  printTransaction("Deposit, 08/01/2020, 50.0, 150.0");
		  inOrder.verify(consolePrinter).
		  printTransaction("Withdrawal, 08/01/2020, -50.0, 100.0");
	}

}
