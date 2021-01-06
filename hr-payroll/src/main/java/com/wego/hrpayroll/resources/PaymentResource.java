package com.wego.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wego.hrpayroll.entities.Payment;
import com.wego.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource  {

	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPaymentFallbackMethod")
	@GetMapping(value = "/worker/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
	public ResponseEntity<Payment> getPaymentFallbackMethod(Long workerId, Integer days){
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
	}
	
}
