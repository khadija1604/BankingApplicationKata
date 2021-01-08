import domain.Account;
import domain.ConsolePrinter;
import domain.OperationsPrinter;
import repository.OperationRepository;
import utils.DateGenerator;

public class BankAccountApplication {

	public static void main(String[] args) {
		
		DateGenerator dateGenerator= new DateGenerator();
		OperationRepository operationRepository = new OperationRepository(dateGenerator);
		
		ConsolePrinter consolePrinter = new ConsolePrinter();
		OperationsPrinter operationsPrinter= new OperationsPrinter(consolePrinter);
		
		Account account= new Account(operationRepository, operationsPrinter);
		
       account.deposit(1000);
       account.withdraw(500);
       account.deposit(200);
       
       account.printOperationsHistory();
    
	}

}
