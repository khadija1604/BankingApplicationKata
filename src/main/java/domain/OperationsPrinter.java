package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationsPrinter {
	
	private ConsolePrinter consolePrinter;
	private static final String HEADER = "Operation, Date, Amount, Balance";
	
	

	public OperationsPrinter(ConsolePrinter consolePrinter) {
		super();
		this.consolePrinter = consolePrinter;
	}



	public void printOperations(List<Operation> operations) {
      consolePrinter.printTransaction(HEADER);
      printLines(operations);
	}
	
	private void printLines(List<Operation> operations) {
	      PrinterHelper printerHelper= new PrinterHelper();
	      operations.stream().map(operation -> constructOperationLine(operation,printerHelper)).
	      collect(Collectors.toCollection(LinkedList::new)).forEach(consolePrinter::printTransaction);
	}
    
	private String constructOperationLine(Operation op , PrinterHelper balanceTracker) {
		return op.getType()+", "+op.getDate()+ ", " +op.getAmount()+ ", "+ balanceTracker.addAndGetBlance(op.getAmount());
	}
	
	private static class PrinterHelper{
		private double balance;
		private  double  addAndGetBlance(double amount) {
			balance+=amount;
			return balance;
		}
	}
}
