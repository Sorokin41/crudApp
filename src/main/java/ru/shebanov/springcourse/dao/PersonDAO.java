package ru.shebanov.springcourse.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ru.shebanov.springcourse.models.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;
	{
		people = new ArrayList<>();
		people.add(new Person(++PEOPLE_COUNT, "Vladislav"));
		people.add(new Person(++PEOPLE_COUNT, "Angelina"));
		people.add(new Person(++PEOPLE_COUNT, "Egor"));
		people.add(new Person(++PEOPLE_COUNT, "Volodya"));
	}
	
	public List<Person> index(){
		return people;
	}
	
	public Person show(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}
	
	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}
}
  