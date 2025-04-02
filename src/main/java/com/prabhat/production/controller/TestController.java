package com.prabhat.production.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prabhat.production.dto.BankDTO;
import com.prabhat.production.interfaces.BankService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bank")
@Slf4j
public class TestController {

	 private final BankService bankService;

	    public TestController(BankService bankService) {
	        this.bankService = bankService;
	    }

	    @PostMapping("/deposit")
	    public double deposit(@RequestBody BankDTO account, @RequestParam double amount) {
	    	double newBalance = bankService.deposit(account, amount);
	    	
	    	log.info("total avilable balance after deposit :{}", newBalance);
	        return newBalance;
	    }
	    
	    @PostMapping("/withdraw")
	    public ResponseEntity<Double> withdraw(@RequestBody BankDTO account, @RequestParam double amount) {
	        double newBalance = bankService.withdraw(account, amount);
	        
	        log.info("Total available balance after withdrawal: {}", newBalance);
	        
	        return new ResponseEntity<>(newBalance, HttpStatus.CREATED);
	    }
}
