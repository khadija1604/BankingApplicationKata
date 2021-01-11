package repository;

import java.util.List;

import domain.Operation;

public interface IOperationRepository {

	void saveDeposit(int amount);

	void saveWithdraw(int amount);

	List<Operation> getAllOperations();

}