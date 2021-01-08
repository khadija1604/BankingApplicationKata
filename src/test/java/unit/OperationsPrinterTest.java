package unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import domain.ConsolePrinter;
import domain.Operation;
import domain.OperationsPrinter;
import utils.OperationTypes;

public class OperationsPrinterTest {
	private List<Operation> EMPTY_OPERATIONS= Collections.emptyList();
	private static final String HEADER = "Operation, Date, Amount, Balance";
	
	private ConsolePrinter consolePrinter= mock(ConsolePrinter.class);


	
	@Test
	 void printOperationsHeader() {
		OperationsPrinter printer= new OperationsPrinter(consolePrinter);
		printer.printOperations(EMPTY_OPERATIONS);
		verify(consolePrinter).printTransaction(HEADER);	
	}
    
	@Test
	 void printAllOperations() {
		OperationsPrinter printer= new OperationsPrinter(consolePrinter);
		  List<Operation> operations = Arrays.asList(new Operation("08/01/2020", 100,OperationTypes.DEPOSIT.getTypeCode()),
				                                      new Operation("08/01/2020", 50,OperationTypes.DEPOSIT.getTypeCode()),
				                                      new Operation("08/01/2020", -50,OperationTypes.WITHDRAWAL.getTypeCode()));
		  printer.printOperations(operations);
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
