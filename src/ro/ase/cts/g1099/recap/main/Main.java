package ro.ase.cts.g1099.recap.main;

import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.g1099.recap.exceptions.IllegalTransferException;
import ro.ase.cts.g1099.recap.exceptions.InsufficientFundsException;
import ro.ase.cts.g1099.recap.models.AccountType;
import ro.ase.cts.g1099.recap.models.BankAccount;
import ro.ase.cts.g1099.recap.models.Banker;

public class Main {

	public static void main(String[] args) {
		Banker bank = new Banker("SDG");
		BankAccount debitAccount = bank.openAccount(AccountType.SAVINGS);
		BankAccount creditAccount = bank.openAccount(AccountType.CURRENT);
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(creditAccount);
		accounts.add(debitAccount);
		accounts.add(bank.openAccount(AccountType.SAVINGS));
		
		try {
			debitAccount.deposit(1000);
			debitAccount.withdraw(100);
			debitAccount.transfer(creditAccount, 100);
			
			System.out.println("Final balance: " + debitAccount.getBalance());
		} catch (IllegalTransferException e) {
			System.out.println("You can't do this");
			e.printStackTrace();
		} catch (InsufficientFundsException e) {
			System.out.println("You need more money");
			e.printStackTrace();
		}
	}

}