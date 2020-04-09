package com.nepdroid.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Before using RibbonClient this feign client annotation was used.	Mentioning the url in app.properties
//@FeignClient(name="currency-exchange-service", url="localhost:8000") 


//Renaming Feign client name to zuul api gateway
//@FeignClient(name="currency-exchange-service")

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//adding currency-exchange-service to the existing uri so that api gateway can invoke this uri
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to);
}
