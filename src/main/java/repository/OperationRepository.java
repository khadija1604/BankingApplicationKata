package repository;

import java.util.ArrayList;
import java.util.List;

import domain.Operation;
import utils.DateGenerator;
import utils.OperationTypes;

public class OperationRepository {
	
	private DateGenerator dateGenerator;
	private List<Operation> operations= new ArrayList<Operation>();
	
	

	public OperationRepository(DateGenerator dateGenerator) {
		super();
		this.dateGenerator = dateGenerator;
	}

	public void saveDeposit(int amount) {
		operations.add(new Operation(dateGenerator.getDateString(), amount,OperationTypes.DEPOSIT.getTypeCode()));
		
	}

	public void saveWithdraw(int amount) {
		operations.add(new Operation(dateGenerator.getDateString(), -amount,OperationTypes.WITHDRAWAL.getTypeCode()));
	}

	public List<Operation> getAllOperations() {
		return operations;
	}

}
