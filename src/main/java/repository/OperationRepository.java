package repository;

import java.util.ArrayList;
import java.util.List;

import domain.Operation;
import utils.DateGenerator;
import utils.OperationTypes;

public class OperationRepository implements IOperationRepository {
	
	private DateGenerator dateGenerator;
	private  final List<Operation> operations= new ArrayList<Operation>();
	
	

	public OperationRepository(DateGenerator dateGenerator) {
		super();
		this.dateGenerator = dateGenerator;
	}

	@Override
	public void saveDeposit(int amount) {
		operations.add(new Operation(dateGenerator.getDateString(), amount,OperationTypes.DEPOSIT.getTypeCode()));
		
	}

	@Override
	public void saveWithdraw(int amount) {
		operations.add(new Operation(dateGenerator.getDateString(), -amount,OperationTypes.WITHDRAWAL.getTypeCode()));
	}

	@Override
	public List<Operation> getAllOperations() {
		return operations;
	}

}
