package com.example.resthateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController  // Komponenty są identyfikowane przez @RestController, która łączy adnotacje @Controller i @ResponseBody
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!"; // %s - wyswietla defaultValue = "World" lub inna wartosc w adresie
                                                         // np: http://localhost:8084/greeting?name=jajko "Hello jajko"
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
		@RequestParam(value = "name", defaultValue = "World") String name){

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
}
