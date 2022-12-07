package java8HomeWork.service.Impl;

import java8HomeWork.clases.Car;
import java8HomeWork.clases.Person;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarServise{
    List<Car>cars=new ArrayList<>();

    @Override
    public String createCar(List<Car> cars) {
        this.cars.addAll(cars);
        return"Mashina uspesno proshla!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if(car.getName().equals(name)) {
                this.cars.remove(car);
            }
            }
        return "Mashinu uspeshno udalili!";
    }


    @Override
    public List<Car> getAll() {
        return this.cars;
    }

    @Override
    public List<Car> findByName(String name, List<Person> people) {
        List<Car>cars1=new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if(car.getName().equals(name)){
                    cars1.add(car);
            }

            }
        }
        return cars1;
    }

    @Override
    public List<Car> findByCountry(String name, List<Person> persons) {
        List<Car> cars1=new ArrayList<>();
        for (Person person : persons) {
            for (Car car : person.getCars()) {
                if(car.getCountryOfOrigin().name().equals(name)){
                cars1.add(car);
            }

            }

        }

        return cars1;
    }
}
