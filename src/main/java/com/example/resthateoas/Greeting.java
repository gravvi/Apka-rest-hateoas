package com.example.resthateoas;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends RepresentationModel<Greeting> {

	private final String content;

	@JsonCreator //@JsonCreator: Sygnalizuje, jak Jackson może utworzyć instancję tego POJO.
	public Greeting(@JsonProperty("content-zawartosc") String content) {  //@JsonProperty: Zaznacza pole, w które Jackson powinien umieścić ten argument konstruktora.

		this.content = content;
	}

	public String getContent() {

		return content;
	}
}
