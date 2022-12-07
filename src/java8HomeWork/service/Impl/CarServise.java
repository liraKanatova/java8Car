package java8HomeWork.service.Impl;

import java8HomeWork.clases.Car;
import java8HomeWork.clases.Person;

import java.util.List;

public interface CarServise {


    String removeCar(String name,List<Car>cars);

    String createCar(List<Car> cars);


    List<Car>getAll();

    List<Car>findByName(String name, List<Person>people);

    List<Car>findByCountry(String name,List<Person>persons);

}
