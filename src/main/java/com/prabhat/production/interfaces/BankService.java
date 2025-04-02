package com.prabhat.production.interfaces;

import com.prabhat.production.dto.BankDTO;

public interface BankService {

	 double deposit(BankDTO bankDTO, double amount); // Return only the balance
	 public double withdraw(BankDTO account, double amount);

}
