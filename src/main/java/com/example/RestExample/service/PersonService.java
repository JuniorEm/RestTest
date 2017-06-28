package com.example.RestExample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.RestExample.entity.Person;


@Service
public class PersonService {

	private static List<Person> persons = new ArrayList<>(); 
	
	static {
		persons.add(new Person(1L, "Tuliao"));
		persons.add(new Person(2L, "Murilera"));
		persons.add(new Person(3L, "Cestarao"));
		persons.add(new Person(4L, "Jefso"));
	}
	
	public Person create(final Person person) {
		Assert.notNull(person.getId(), "ID nao pode ser nulo");
		Assert.notNull(person.getName(), "Nome nao pode ser nulo");
		
		Person created = new Person(person.getId(), person.getName());
		
		Boolean added = persons.add(created);
		
		if (added.equals(Boolean.TRUE))
			return created;
		else
			throw new IllegalStateException("An error ocurred");
	}
	
	public Person findById(final Long id) {
		return persons.stream().filter(selected -> selected.getId().equals(id)).findAny()
				.orElseThrow(() -> new RuntimeException("Try again later"));
	}
	
	public List<Person> findAll() {
		return persons;
	}
	
	public void delete(final Long id) {
		persons.remove(this.findById(id));
	}
	
	public void update(final Person person) {
		
		Person found = this.findById(person.getId());
		found.setName(person.getName());
		persons.add(found);
		
	}
	
	
}
