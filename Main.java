import java.util.Scanner;

// Contact Class
class Contact {
    private String name;
    private String phone;
    private String email;
    private String city;

    // Constructor
    public Contact(String name, String phone, String email, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Setter Methods
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Display Method
    public void display() {
        System.out.printf("%-20s %-15s %-25s %-15s\n",
                name, phone, email, city);
    }
}

// Directory Class
class Directory {
    private Contact[] contacts;
    private int count;

    // Constructor
    public Directory() {
        contacts = new Contact[100];
        count = 0;
    }

    // Add Contact
    public void addContact(String name, String phone,
                           String email, String city) {

        if (count < contacts.length) {
            contacts[count] = new Contact(name, phone, email, city);
            count++;
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Directory is full!");
        }
    }

    // Display All Contacts
    public void displayAll() {

        if (count == 0) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-25s %-15s\n",
                "Name", "Phone", "Email", "City");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            contacts[i].display();
        }
    }

    // Search Contact
    public void searchContact(String keyword) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(keyword)
                    || contacts[i].getPhone().equals(keyword)) {

                System.out.println("\nContact Found:");
                System.out.println("---------------------------------------------------------------");
                System.out.printf("%-20s %-15s %-25s %-15s\n",
                        "Name", "Phone", "Email", "City");
                System.out.println("---------------------------------------------------------------");

                contacts[i].display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Update Contact
    public void updateContact(String name,
                              String newPhone,
                              String newEmail,
                              String newCity) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                contacts[i].setPhone(newPhone);
                contacts[i].setEmail(newEmail);
                contacts[i].setCity(newCity);

                System.out.println("Contact updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Delete Contact
    public void deleteContact(String name) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                contacts[count - 1] = null;
                count--;

                System.out.println("Contact deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Directory directory = new Directory();

        int choice;

        do {

            System.out.println("\n===== CONTACT DIRECTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name   : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone  : ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email  : ");
                    String email = sc.nextLine();

                    System.out.print("Enter City   : ");
                    String city = sc.nextLine();

                    directory.addContact(name, phone, email, city);
                    break;

                case 2:

                    directory.displayAll();
                    break;

                case 3:

                    System.out.print("Enter Name or Phone to Search: ");
                    String keyword = sc.nextLine();

                    directory.searchContact(keyword);
                    break;

                case 4:

                    System.out.print("Enter Contact Name to Update: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter New Phone : ");
                    String newPhone = sc.nextLine();

                    System.out.print("Enter New Email : ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New City  : ");
                    String newCity = sc.nextLine();

                    directory.updateContact(updateName,
                            newPhone, newEmail, newCity);
                    break;

                case 5:

                    System.out.print("Enter Contact Name to Delete: ");
                    String deleteName = sc.nextLine();

                    directory.deleteContact(deleteName);
                    break;

                case 6:

                    System.out.println("Thank You for using Contact Directory System!");
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}