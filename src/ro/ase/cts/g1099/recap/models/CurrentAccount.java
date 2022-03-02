package ro.ase.cts.g1099.recap.models;

public class CurrentAccount extends BankAccount{
	
	//if we have a caps variable it is static and final. We write the statics with caps here, as a convention
	public static final double MAX_CREDIT = 500;

	public CurrentAccount(String iban) {
		super(iban);
		this.balance = CurrentAccount.MAX_CREDIT;
	}
	
	
	

}
