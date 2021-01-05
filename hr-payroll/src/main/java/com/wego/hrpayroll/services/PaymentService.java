package com.wego.hrpayroll.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wego.hrpayroll.entities.Payment;
import com.wego.hrpayroll.entities.Worker;
import com.wego.hrpayroll.feignclients.WoerkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WoerkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days)
	{
		
	    Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
