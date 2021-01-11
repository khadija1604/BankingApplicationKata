package domain;

import repository.IOperationRepository;

public class Account implements IAccount {

    private IOperationRepository operationRepository;
    private IOperationsPrinter operationsPrinter;
    
	public Account(IOperationRepository operationRepository,IOperationsPrinter operationsPrinter) {
	  this.operationRepository = operationRepository;
	  this.operationsPrinter = operationsPrinter;
	}

	@Override
	public void deposit(int amount) {
		operationRepository.saveDeposit(amount);
	}
    
	@Override
	public void withdraw(int amount) {
		operationRepository.saveWithdraw(amount);
		
	}
	
	@Override
	public void printOperationsHistory() {
		operationsPrinter.printOperations(operationRepository.getAllOperations());
	}




}
