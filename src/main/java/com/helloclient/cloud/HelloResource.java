package com.helloclient.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {


	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
    
    @Autowired
    private HelloServerFeignClient feignclient;


    @GetMapping
    public String hello() {
		
		 return feignclient.getClient();
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
