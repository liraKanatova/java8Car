package java8HomeWork.service;

import java8HomeWork.clases.Car;
import java8HomeWork.clases.Person;

import java.util.List;

public interface PersonService {
    String createPerson(List<Person> people);

    String removePerson(String name, List<Person> people);

    List<Person> getAll(List<Person> people);

    List<Person> findByName(String name, List<Person> people);

    List<Person> findByCarName(String name, List<Person> people);

    String payCars(String name, List<Person> person, String carName, List<Car> cars);

    List<Person>sortPersonDateOfBirth(List<Person>persons);

    List<Person>sortPersonName(List<Person>persons);

    String sortGender(List<Person>person);

    int getAge(Person person);
}
