package io.girirajvyas.springcloud.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingEndpoint {

	private static final String MESSAGE = "Hello From Spring Boot";

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String sayHello() {
		return MESSAGE;
	}
}
