package UI;

import Domain.Client;
import Domain.Medicament;
import Domain.Transaction;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {

    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;

    private Scanner scanner;

    public Console (MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;

        this.scanner = new Scanner(System.in);
    }


    private void showMenu () {
        System.out.println("1. Medicament  CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Transaction CRUD");
        System.out.println("x. Exit");
    }

    public void run () {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMedicamentCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "3":
                    runTransactionCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runTransactionCrud () {
        while (true) {
            System.out.println("1. Add or update a transaction");
            System.out.println("2. Remove a transaction");
            System.out.println("3. View all transactions");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateTransaction();
                    break;
                case "2":
                    handleRemoveTransaction();
                    break;
                case "3":
                    handleViewTransactions();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleAddUpdateTransaction () {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter medicine id : ");
            String idMedicament = scanner.nextLine();
            System.out.print("Enter client card : ");
            String idClientCard = scanner.nextLine();
            System.out.print("Enter number of items  ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Transaction transaction = transactionService.addOrUpdate(id, idMedicament, idClientCard, numberOfItems, date, time);
            System.out.println(String.format("Added transaction id=%s, paid price=%f, discount=%f%%", transaction.getId(), transaction.getDiscountedPrice(), transaction.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleRemoveTransaction () {
        try{
            System.out.println("Enter the id transaction to remove");
            String id = scanner.nextLine();
            transactionService.remove(id);
            System.out.println("Transanction removed");
        } catch (Exception ex){
            System.out.println("Errors:\n" + ex.getMessage());
        }

    }

    private void handleViewTransactions () {
        for (Transaction transaction: transactionService.getAll()){
            System.out.println(transaction);
        }
    }

    private void runMedicamentCrud () {
        while (true) {
            System.out.println("1. Add or update a medicine");
            System.out.println("2. Remove a medicine");
            System.out.println("3. View all medicines");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMedicament();
                    break;
                case "2":
                    handleRemoveMedicament();
                    break;
                case "3":
                    handleViewMedicamente();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewMedicamente () {
        for (Medicament medicament: medicamentService.getAll()){
            System.out.println(medicament);
        }
    }

    private void handleRemoveMedicament () {
        try {
            System.out.println("Enter the id of medicine to remove:");
            String id = scanner.nextLine();
            medicamentService.remove(id);
            System.out.println("Medicine removed.");
        }
        catch (Exception ex){
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMedicament () {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name : ");
            String name = scanner.nextLine();
            System.out.print("Enter producer: ");
            String producer = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter prescription (true / false): ");
            boolean prescription = Boolean.parseBoolean(scanner.nextLine());

            medicamentService.addOrUpdate(id,name,producer, price,prescription);
            System.out.println("Medicine added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }

    }


    private void runClientCrud () {
        while (true) {
            System.out.println("1. Add or update a client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClient();
                    break;
                case "2":
                    handleRemoveClient();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleRemoveClient () {
        try {
            System.out.println("Enter the id to remove");
            String id = scanner.nextLine();
            clientService.remove(id);
            System.out.println("Client removed");
        } catch (Exception exception) {
            System.out.println("Errors:\n" + exception.getMessage());
        }
    }

    private void handleAddUpdateClient () {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter last name : ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name : ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP : ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth : ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration : ");
            String dateOfRegistration = scanner.nextLine();

            clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewClients () {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

}