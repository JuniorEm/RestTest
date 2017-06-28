package com.example.RestExample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestExample.entity.Person;
import com.example.RestExample.service.PersonService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService; 
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create a Person", notes = "Create a person by passed model")
	public Person create(@RequestBody @Valid final Person person) {
		return this.personService.create(person);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Find a person", notes = "Find a person by id")
	public Person findById(@PathVariable("id") final Long id) {
		return this.personService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Update a person", notes = "Update a person by passed body")
	public void update(@RequestBody @Valid final Person person) {
		this.personService.update(person);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a person", notes = "Delete")
	public void delete(@PathVariable("id") final Long id) {
		this.personService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find all people", notes = "Find all people")
	public List<Person> findAll() {
		return this.personService.findAll();
	}
	
}
