import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner;
    static ArrayList<Contact> contacts = new ArrayList<>();
    static ArrayList<Message> messages = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Contect and Messages App.");
        options();
    }

    private static void options() throws InterruptedException{
        scanner = new Scanner(System.in);
        String answerStr;
        int answer;
        do{
            System.out.println("\t1. Manage contacts");
            System.out.println("\t2. Messages");
            System.out.println("\t3. Quit");
            answerStr = scanner.next(); 
            try{
                answer = Integer.parseInt(answerStr);
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!!");
                answer = 0;
                Thread.sleep((long) 1000.0);
            }
        }while(answer>3 || answer<1);
        if (answer == 1) {
            System.out.println("Manage Contacts :");
            contactsOptions();
        }else if(answer == 2){
            System.out.println("Messages :");
            messagesOptions();
        }
        else{
            System.exit(1);
        }
    }

    private static void contactsOptions() throws InterruptedException{
        scanner = new Scanner(System.in);
        String answerStr;
        int answer;
        do{
            System.out.println("\t1. Show all contacts");
            System.out.println("\t2. Add new contact");
            System.out.println("\t3. Search for a contact");
            System.out.println("\t4. Delete a contact");
            System.out.println("\t5. Go back");
            answerStr = scanner.next(); 
            try{
                answer = Integer.parseInt(answerStr);
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!!");
                answer = 0;
                Thread.sleep((long) 1000.0);
            }
        }while(answer>5 || answer<1);
        if (answer == 1) {
            showContacts();
        }else if(answer == 2){
            addContact();
        }else if(answer == 3){
            searchForContact();
        }else if(answer == 4){
            deleteContact();
        }
        else{
            options();
        }
    }

    private static void deleteContact() throws InterruptedException {
        if (contacts.size()==0) {
            System.out.println("You have no contacts to delete!!");
        }else{
            Boolean notFound = true;
            System.out.println("Delete a contact :");
            System.out.println("Name of contact :");
            String name;
            Contact c = null;
            scanner = new Scanner(System.in);
            do{
                name = scanner.nextLine();
            }while(name.isBlank());
            for (Contact contact : contacts) {
                if(contact.getName().equals(name.trim())){
                    notFound = false;
                    c = contact;
                    break;
                }
            }
            if (notFound) {
                System.out.println("No contact with the name : "+name+"!!");
            }else{
                contacts.remove(c);
                System.out.println("Delete Done");
            }
        }
        contactsOptions();
    }

    private static void addContact() throws InterruptedException{
        System.out.println("Adding  a contact:");
        String name;
        String number;
        scanner = new Scanner(System.in);
        System.out.println("Name :");
        do{
            name = scanner.nextLine();
        }while(name.isBlank());
        System.out.println("Number :");
        do{
            number = scanner.nextLine();
        }while(number.isBlank());

        contacts.add(new Contact(name.trim(), number.trim()));
        contactsOptions();
    }

    private static void showContacts() throws InterruptedException{
        if(contacts.size()==0){
            System.out.println("You have NO contacts");
        }else{
            System.out.println("List of contacts :");
            System.out.println("**********************");
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("**********************");
            }
        }
        contactsOptions();
    }

    private static void searchForContact() throws InterruptedException{
        boolean notFound= true;
        System.out.println("Search for a contact :");
        System.out.println("Name of contact :");
        String name;
        scanner = new Scanner(System.in);
        do{
            name = scanner.nextLine();
        }while(name.isBlank());
        for (Contact contact : contacts) {
            if(contact.getName().equals(name.trim())){
                notFound = false;
                System.out.println("Name : "+name.trim()+"\nNumber : "+contact.getNumber());
                System.out.println("*****************");
            }
        }
        if(notFound){
            System.out.println("Not contact found!!");
        }
        contactsOptions();
    }

    private static void messagesOptions() throws InterruptedException{
        scanner = new Scanner(System.in);
        String answerStr;
        int answer;
        do{
            System.out.println("\t1. Show the list of all mesages");
            System.out.println("\t2. Send a new message");
            System.out.println("\t3. Go back");
            answerStr = scanner.next(); 
            try{
                answer = Integer.parseInt(answerStr);
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!!");
                answer = 0;
                Thread.sleep((long) 1000.0);
            }
        }while(answer>3 || answer<1);
        if (answer == 1) {
            showMessages();
        }else if(answer == 2){
            sendMessage();
        }
        else{
            options();
        }
    }

    private static void showMessages() throws InterruptedException {
        if (messages.size()==0) {
            System.out.println("You have sent no messages");
        }
        else{
            System.out.println("All the messages :");
            for (Message message : messages) {
                System.out.println(message);
                System.out.println("****************");
            }
        }
        messagesOptions();
    }

    private static void sendMessage() throws InterruptedException {
        String to;
        scanner = new Scanner(System.in);
        System.out.println("Send a message :");
        System.out.println("Contact name :");
        do{
            to = scanner.nextLine();
        }while(to.isBlank());
        to = to.trim();
        boolean contactDoesNotExist = true;
        for (Contact contact : contacts) {
            if (contact.getName().equals(to)) {
                contactDoesNotExist = false;
                break;
            }
        }
        if(contactDoesNotExist){
            System.out.println("Contact does not exist!!");
        }else{
            String message;
            System.out.println("The message :");
            do{
                message = scanner.nextLine();
            }while(message.isBlank());
            messages.add(new Message(to, message.trim()));
        }
        messagesOptions();
    }
}