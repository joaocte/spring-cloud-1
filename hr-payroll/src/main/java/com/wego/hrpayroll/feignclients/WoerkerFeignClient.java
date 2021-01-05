package com.wego.hrpayroll.feignclients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wego.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
@RibbonClient(name = "hr-worker")
public interface WoerkerFeignClient {

	@GetMapping(value="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
