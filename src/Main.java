import java8HomeWork.clases.Car;
import java8HomeWork.clases.Person;
import java8HomeWork.enums.Colour;
import java8HomeWork.enums.Country;
import java8HomeWork.enums.Gender;
import java8HomeWork.exception.MyException;
import java8HomeWork.service.Impl.CarServiceImpl;
import java8HomeWork.service.Impl.CarServise;
import java8HomeWork.service.Impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {

        Person person1 = new Person("Alan", LocalDate.of(1996, 12, 5), Gender.MALE, BigDecimal.valueOf(5000), "123456", null);
        Person person2 = new Person("Inna", LocalDate.of(1998, 9, 25), Gender.MALE, BigDecimal.valueOf(13000), "223456", null);
        Person person3 = new Person("Nik", LocalDate.of(1995, 8, 11), Gender.MALE, BigDecimal.valueOf(16000), "323456", null);
        Person person4 = new Person("Ailin", LocalDate.of(2000, 10, 7), Gender.MALE, BigDecimal.valueOf(17000), "423456", null);
        Person person5 = new Person("Oleg", LocalDate.of(2001, 5, 8), Gender.MALE, BigDecimal.valueOf(9000), "523456", null);
        ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(person1, person2, person3, person3, person4, person5));
        PersonServiceImpl personService = new PersonServiceImpl();


        Car car1 = new Car("BMW", "503", BigDecimal.valueOf(15000), Year.of(2020), Colour.BLACK, Country.CERMANY);
        Car car2 = new Car("BMW", "E12", BigDecimal.valueOf(13000), Year.of(2018), Colour.WHITE, Country.CERMANY);
        Car car3 = new Car("Lexus", "LS", BigDecimal.valueOf(17000), Year.of(2015), Colour.WHITE, Country.JAPAN);
        Car car4 = new Car("Audi", "A8", BigDecimal.valueOf(9000), Year.of(2008), Colour.RED, Country.CERMANY);
        Car car5 = new Car("Audi", "S4", BigDecimal.valueOf(5000), Year.of(2009), Colour.BLUE, Country.CERMANY);
        ArrayList<Car> carArrayList = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car4, car5));
        CarServiceImpl carService = new CarServiceImpl();

        System.out.println("""
                1 CreatePerson!
                2 RemovePerson!
                3 GetAll!
                4 FindByName!
                5 FindByCarName!
                6 PayCars!
                7 SortPersonDateOfBirth!
                8 SortPersonName!
                9 CreateCar!
                10 RemoveCar!
                11 GetAll!
                12 FindByName!
                13 FindByCountry!""");
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> System.out.println(personService.createPerson(personArrayList));
                case 2 -> {
                    System.out.println("Pojaluista napishite imia: ");
                    System.out.println(personService.removePerson(scanner1.nextLine(), personArrayList));
                }
                case 3 -> System.out.println(personService.getAll(personArrayList));
                case 4 -> {
                    System.out.println("Pojaluista napishite imia: ");
                    System.out.println(personService.findByName(scanner1.nextLine(), personArrayList));
                }
                case 5 -> {
                    System.out.println("Pojaluista napishite nazvanie avtomobili: ");
                    System.out.println(personService.findByCarName(scanner1.nextLine(), personArrayList));
                }
                case 6 -> {
                    System.out.println("Pojaluista napishite imia: ");
                System.out.println("Pojaluista napishite nazvanie avtomobili: ");
                    System.out.println(personService.payCars(scanner1.nextLine(), personArrayList, scanner1.nextLine(), carArrayList));
                }
                case 7 -> System.out.println(personService.sortPersonDateOfBirth(personArrayList));
                case 8 -> System.out.println(personService.sortPersonName(personArrayList));
                case 9 -> System.out.println(carService.createCar(carArrayList));
                case 10 -> {
                    System.out.println("Pojaluista napishite nazvanie avtomobili: ");
                    System.out.println(carService.removeCar(scanner1.nextLine(), carArrayList));
                }
                case 11 -> System.out.println(carService.getAll());
                case 12 -> {
                    System.out.println("Pojaluista napishite nazvanie avtomobili: ");
                    System.out.println(carService.findByName(scanner1.nextLine(), personArrayList));
                }
                case 13 -> {
                    System.out.println("Pojaluista napishite stranu proizvodstva avtomobilia");
                    System.out.println(carService.findByCountry(scanner1.nextLine(), personArrayList));

                }
            }


        }
    }}