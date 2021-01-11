import domain.Account;
import domain.ConsolePrinter;
import domain.IAccount;
import domain.IOperationsPrinter;
import domain.OperationsPrinter;
import repository.IOperationRepository;
import repository.OperationRepository;
import utils.DateGenerator;

public class BankAccountApplication {

	public static void main(String[] args) {
		
		DateGenerator dateGenerator= new DateGenerator();
		IOperationRepository operationRepository = new OperationRepository(dateGenerator);
		
		ConsolePrinter consolePrinter = new ConsolePrinter();
		IOperationsPrinter operationsPrinter= new OperationsPrinter(consolePrinter);
		
		IAccount account= new Account(operationRepository, operationsPrinter);
		
       account.deposit(1000);
       account.withdraw(500);
       account.deposit(200);
       
       account.printOperationsHistory();
    
	}

}
