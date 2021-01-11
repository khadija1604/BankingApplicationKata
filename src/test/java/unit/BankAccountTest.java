package unit;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import domain.Account;
import domain.IAccount;
import domain.Operation;
import domain.OperationsPrinter;
import repository.OperationRepository;
public class BankAccountTest {
	
    private IAccount account;
    
	@Mock
	private OperationRepository operationRepository;

    @Mock
	private OperationsPrinter operationsPrinter ;

	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		account = new Account(operationRepository,operationsPrinter);
	}
	
	@Test
	@DisplayName("US1: The client can make deposit on his account")
	void deposit_operation() {
		account.deposit(100);
		verify(operationRepository).saveDeposit(100);
	}
	
	@Test
	@DisplayName("US2: The client can make whithdrawal from his account")
	void withdrawal_operation() {
		account.withdraw(100);
		verify(operationRepository).saveWithdraw(100);
	}
	
	@Test
	@DisplayName("US3: The client can display the history of all his transactions")
	void operations_History_printer() {
		List<Operation> operations = new ArrayList<Operation>();
		when(operationRepository.getAllOperations()).thenReturn(operations);
		account.printOperationsHistory();
		verify(operationsPrinter ).printOperations(operations);
	}

}
