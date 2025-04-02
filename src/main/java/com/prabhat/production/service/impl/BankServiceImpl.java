package com.prabhat.production.service.impl;


import org.springframework.stereotype.Service;

import com.prabhat.production.dto.BankDTO;
import com.prabhat.production.interfaces.BankService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankServiceImpl implements BankService {

	@Override
    public double deposit(BankDTO bankDTO, double amount) {
		
        bankDTO.setBalance(bankDTO.getBalance() + amount); // Update balance
        log.info("total avilable amount are :{}",bankDTO.getBalance());
        return bankDTO.getBalance(); // Return updated balance only
    }

	 @Override
	 public double withdraw(BankDTO account, double amount) {
	     if (account.getBalance() < amount) {
	         log.info("Insufficient balance! Available: {}, Requested: {}", account.getBalance(), amount);
	         throw new RuntimeException("Insufficient balance! Available balance: ₹" + account.getBalance());
	     }

	     log.info("Debited amount is: {}", amount);
	     double newBalance = account.getBalance() - amount;
	     account.setBalance(newBalance);

	     log.info("Withdrawal successful. New balance: {}", newBalance);
	     return newBalance;
	 }

}
