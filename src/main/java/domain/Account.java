package domain;

import repository.OperationRepository;

public class Account {

    private OperationRepository operationRepository;
    private OperationsPrinter operationsPrinter;
    
	public Account(OperationRepository operationRepository,OperationsPrinter operationsPrinter) {
	  this.operationRepository = operationRepository;
	  this.operationsPrinter = operationsPrinter;
	}

	public void deposit(int amount) {
		operationRepository.saveDeposit(amount);
	}
    
	public void withdraw(int amount) {
		operationRepository.saveWithdraw(amount);
		
	}
	
	public void printOperationsHistory() {
		operationsPrinter.printOperations(operationRepository.getAllOperations());
	}




}
