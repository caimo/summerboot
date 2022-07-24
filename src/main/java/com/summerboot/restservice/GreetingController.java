package com.summerboot.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws Exception {
		if(name.equals("error")){
			throw new Exception("error");
		}
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	@GetMapping("/error")
	public Greeting error() {

		return new Greeting(counter.incrementAndGet(), "you meet an error!");
	}
}
