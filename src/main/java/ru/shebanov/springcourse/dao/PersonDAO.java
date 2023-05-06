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
		people.add(new Person(++PEOPLE_COUNT, "Vladislav", 25, "Vladislav@mail.ru"));
		people.add(new Person(++PEOPLE_COUNT, "Angelina", 23, "Angelina@mail.ru"));
		people.add(new Person(++PEOPLE_COUNT, "Egor", 26, "Egor@mail.ru"));
		people.add(new Person(++PEOPLE_COUNT, "Volodya", 30, "Volodya@mail.ru"));
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
	
	public void update(int id, Person updatedPerson) {
		Person personToBeUpdated = show(id);
		personToBeUpdated.setAge(updatedPerson.getAge());
		personToBeUpdated.setEmail(updatedPerson.getEmail());
		personToBeUpdated.setName(updatedPerson.getName());
	}
	
	public void delete(int id) {
		people.removeIf(person -> person.getId() == id);
	}
}

  