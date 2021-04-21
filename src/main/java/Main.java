import controller.Library;
import controller.Menu;
import controller.Registration;
import entity.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    Registration registration = new Registration();
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu(registration);

    public static void main(String[] args) {

        Main main = new Main();

        main.signIn();

    }

    void signIn() {
        String userInput;

        do {
            System.out.println("\nPlease choose: \n" +
                    "1. Existing Reader" + "\n" +
                    "2. New Reader" + "\n" +
                    "3. List of library readers" + "\n" +
                    "4. Exit" + "\n");

            System.out.print("Enter your choice: ");

            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    findExistingReader();
                    break;
                case "2":
                    newReader();
                    break;
                case "3":
                    showAllReaders();
                    break;
                case "4":
                    System.out.println("See you later, come again!");
                    ;
                    break;
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("4"));
        return;
    }

    void showAllReaders() {
        System.out.println("LIST of LIBRARY READERS");
        registration.getAllReaders();
        System.out.println();
    }

    void findExistingReader() {

        System.out.print("Please enter your name: ");

        String existingReaderName = input.nextLine();
        var foundReader = registration.findReader(existingReaderName);
        if (existingReaderName.isBlank() || foundReader.size() == 0) {
            System.out.println("Reader " + existingReaderName + " not found");

        } else {
            System.out.println("Welcome to the Library " + existingReaderName + "!!!");
            System.out.println(registration.setActiveReader(existingReaderName));
            menu.showLibraryMenu();
        }
    }

    void newReader() {
        Reader newReader = new Reader();

        System.out.print("Enter Your Name: ");
        newReader.setName(input.nextLine());

        while (!newReader.getName().isBlank()) {
            System.out.println(registration.addReader(newReader));
            System.out.println(registration.setActiveReader(newReader.getName()));
            showAllReaders();

            menu.showLibraryMenu();
        }
        System.out.println("ERROR: The name cannot be empty");
        return;
    }
}






