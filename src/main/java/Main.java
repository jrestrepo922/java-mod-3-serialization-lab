import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("=========== Welcome to Serialize Objects Program==============");
            String optionsType = "0";
            //ask if a new file or an existing file
            while(!optionsType.equals("3")){
                // ask what type of services
                optionsType = PersonService.provideOptionsType(scanner);
                if(optionsType.equals("1")){
                   Person newPerson = PersonService.createPerson(scanner);
                   PersonService.savePerson(newPerson);
                } else if(optionsType.equals("2")){
                    System.out.println("Please provide the filename you want to restore");
                    String fileNameInput = PersonService.getUserInput(scanner);
                    while (fileNameInput.isEmpty() || fileNameInput.isBlank()) {
                        fileNameInput = PersonService.getUserInput(scanner);
                    }
                    System.out.println(PersonService.restorePerson(fileNameInput));
                }
            }
            System.out.println("System was exited");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
