import java.io.IOException;
import java.util.Scanner;

public class PersonService {
    public static String getUserInput(Scanner scanner) {
        String userInput = scanner.nextLine();
        return userInput;
    }
    // method to display the options
    public static String provideOptionsType(Scanner scanner) {
        System.out.println("Type 1: save person to file");
        System.out.println("Type 2: create person object from file");
        System.out.println("Type 3: Exit the program");
        String selection = getUserInput(scanner);
        while (!(selection.equals("1") || selection.equals("2") || selection.equals("3"))) {
            selection = getUserInput(scanner);
        }

        return selection;
    }

    // method that gathers information from user and creates a person
    public static Person createPerson(Scanner scanner)  {

        // Get all the detail for the new user that will be added
        System.out.println("Please provide first name");
        String firstName = getUserInput(scanner);
        while (firstName.isEmpty() || firstName.isBlank()) {
            firstName = getUserInput(scanner);
        }

        System.out.println("Please provide last name");
        String lastName = getUserInput(scanner);
        while (lastName.isEmpty() || lastName.isBlank()) {
            lastName = getUserInput(scanner);
        }

        System.out.println("Please provide birth year");
        String birthYear = getUserInput(scanner);
        while (birthYear.isEmpty() || birthYear.isBlank()) {
            birthYear = getUserInput(scanner);
        }
        Integer birthYearInt = Integer.parseInt(birthYear);

        System.out.println("Please provide birth month");
        String birthMonth = getUserInput(scanner);
        while (birthMonth.isEmpty() || birthMonth.isBlank()) {
            birthMonth = getUserInput(scanner);
        }
        Integer birthMonthInt = Integer.parseInt(birthMonth);

        System.out.println("Please provide birth day");
        String birthDay = getUserInput(scanner);
        while (birthDay.isEmpty() || birthDay.isBlank()) {
            birthDay = getUserInput(scanner);
        }
        Integer birthDayInt = Integer.parseInt(birthDay);

        return  new Person(firstName, lastName, birthYearInt, birthMonthInt, birthDayInt);

    }

    // method that saves a person into a file
    public static void savePerson(Person person) throws IOException {
        // must use the firstname as the file name
        String fileName = person.getFirstName();
        Person.serializePerson(person, fileName);
    }


    // method to restore the person from the serialized file
        // display output in console
    public static Person restorePerson(String fileName) throws IOException {
        Person restoredPerson = Person.deserializePerson(fileName);
        return restoredPerson;
    }


}
