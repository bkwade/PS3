package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Main.Account;
import Exceptions.InsufficientFundsException;

public class AccountTest extends Account{
	
	@Test
	public void Tests() throws InsufficientFundsException {
		Account account = new Account(1122,20000,0.045);
		assertEquals(account.getId(),1122);
		assertEquals(account.getBalance(),20000,0.001);
		assertEquals(account.getAnnualInterestRate(),0.045,0.001);
		
		account.deposit(3000);
		try {
			account.withdraw(2500);
		}
		catch(InsufficientFundsException e) {
			System.out.println("Insufficient Funds. Short $ " + e.getAmount());
		}
		
		System.out.println("Balance: " + account.getBalance());
		System.out.println("Monthly Interest Rate: " + account.monthlyInterestRate());
		System.out.println("Account Creation Date: " + account.getDateCreated());
		
		try {
			account.withdraw(30000);
		}
		catch(InsufficientFundsException e) {
			System.out.println("Short $ " +e.getAmount());
		}
		
	}

}
