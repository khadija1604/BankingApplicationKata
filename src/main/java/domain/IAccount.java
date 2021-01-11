package domain;

public interface IAccount {

	void deposit(int amount);

	void withdraw(int amount);

	void printOperationsHistory();

}