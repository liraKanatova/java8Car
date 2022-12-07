package java8HomeWork.service.Impl;

import java8HomeWork.clases.Car;
import java8HomeWork.clases.Person;
import java8HomeWork.enums.Gender;
import java8HomeWork.service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    List<Person> people = new ArrayList<>();
    List<Car>cars=new ArrayList<>();

    @Override
    public String createPerson(List<Person> people) {
        people.addAll(people);
        return "Person uspeshno proshel!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                this.people.remove(person);
            }

        }
        return "Person uspeshno udalili! ";
    }

    @Override
    public List<Person> getAll(List<Person> people) {
        for (Person person : people) {

        }
        return people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().contains(name)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> people1 = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if (car.getName().equals(name)) {
                    people1.add(person);
                }
            }
            return people1;
        }
        return null;
    }
    @Override
    public String payCars(String name, List<Person> person, String carName, List<Car> cars) {
        for (Person person1 : person) {
            if (person1.getName().equals(name)) {
                for (Car car : cars) {
                    if (car.getName().equals(name)) {
                        int value =person1.getMoney().subtract(car.getPrice()).intValue();
                        if(value>=0){
                       if(person1.getCars()==null){
                           person1.setCars(List.of(car));
                           this.cars.removeAll(cars);
                           this.cars.add(car);
                           person1.setMoney(person1.getMoney().subtract(car.getPrice()));
                       }else {
                           person1.setCars(this.cars);
                           this.cars.add(car);
                           cars.remove(car);
                           person1.setMoney(person1.getMoney().subtract(car.getPrice()));
                       }
                       return "Uspeshno kupili mashinu!";
                       }else {
                            return "Ne doststochno vashih deneg!";
                        }

                    }
                }
            }
        }
        return "Mashina prodona!";
    }


    public static Comparator<Person> sortPersonDateOfBirth = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }

    };

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
return sortPersonDateOfBirth(persons);

    }

    public static Comparator<Person> sortPersonName=new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        return sortPersonName(persons);
    }

    @Override
    public String sortGender(List<Person> person) {
        List<Person> males=new ArrayList<>();
        List<Person> females=new ArrayList<>();
        for (Person person1 : person) {
            if(person1.getGender().equals(Gender.MALE))males.add(person1);
       else females.add(person1);

        }
        return "successfully";
    }

    @Override
    public int getAge(Person person) {
        return  Period.between(person.getDateOfBirth(),LocalDate.now()).getYears();

    }
}
