package unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Operation;
import repository.OperationRepository;
import utils.DateGenerator;
import utils.OperationTypes;

public class OperationRepositoryTest {
    private  static final String OPERATION_DATE= "08/01/2021";
	private  OperationRepository operationRepository;
	private DateGenerator dateGenerator = mock(DateGenerator.class);
	
	@BeforeEach
	void init() {
		operationRepository= new OperationRepository(dateGenerator);
	}
	
	@Test
	@DisplayName("OperationRepository should store deposit")
	void store_deposit(){
		when(dateGenerator.getDateString()).thenReturn(OPERATION_DATE);
		operationRepository.saveDeposit(200);
		List<Operation> operations= operationRepository.getAllOperations();
		assertEquals(1, operations.size());
		assertEquals(operations.get(0), operation(OPERATION_DATE,200,OperationTypes.DEPOSIT.getTypeCode()));
	}
	
	@Test
	@DisplayName("OperationRepository should store withdrawal")
	void store_withdrawal(){
		when(dateGenerator.getDateString()).thenReturn(OPERATION_DATE);
		operationRepository.saveWithdraw(200);
		List<Operation> operations= operationRepository.getAllOperations();
		assertEquals(1, operations.size());
		assertEquals(operations.get(0), operation(OPERATION_DATE,-200, OperationTypes.WITHDRAWAL.getTypeCode()));
	}
	
	private Operation operation(String date, double amount,String type) {
		return new Operation(date, amount, type);
	}
}
