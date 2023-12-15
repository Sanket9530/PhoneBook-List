import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    
    private Map<String, String> contacts;
    
    public PhoneBook() {
        contacts = new HashMap<String, String>();
    }
    
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println(name + " has been added to the phone book with phone number " + phoneNumber);
    }
    
    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            String phoneNumber = contacts.get(name);
            contacts.remove(name);
            System.out.println(name + " has been removed from the phone book with phone number " + phoneNumber);
        } else {
            System.out.println(name + " was not found in the phone book");
        }
    }
    
    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            String phoneNumber = contacts.get(name);
            System.out.println(name + " is in the phone book with phone number " + phoneNumber);
        } else {
            System.out.println(name + " was not found in the phone book");
        }
    }
    
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("What would you like to do? (add, delete, search, exit)");
            String action = scanner.nextLine().toLowerCase();
            
            switch (action) {
                case "add":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    break;
                    
                case "delete":
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    phoneBook.deleteContact(name);
                    break;
                    
                case "search":
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    phoneBook.searchContact(name);
                    break;
                    
                case "exit":
                    exit = true;
                    break;
                    
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
        
        scanner.close();
    }

}
