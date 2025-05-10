import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> pendingTasks = new ArrayList<>();
    static ArrayList<String> completedTasks = new ArrayList<>();
    static final String PENDING_FILE = "pending_tasks.txt";
    static final String COMPLETED_FILE = "completed_tasks.txt";

    public static void main(String[] args) {
        pendingTasks = FileHandler.loadData(PENDING_FILE);
        completedTasks = FileHandler.loadData(COMPLETED_FILE);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            choice = InputValidator.getUserInput();
            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> completeTask();
                case 3 -> viewTasks();
                case 4 -> saveAndExit();
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }

    static void addTask(Scanner scanner) {
        System.out.print("Enter new task: ");
        scanner.nextLine();
        String task = scanner.nextLine();
        pendingTasks.add(task);
        System.out.println("Task added.");
    }

    static void completeTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        viewTasks();
        System.out.print("Enter index of task to complete: ");
        int index = InputValidator.getUserInput();
        try {
            String completed = pendingTasks.remove(index);
            completedTasks.add(completed);
            System.out.println("Task completed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    static void viewTasks() {
        System.out.println("Pending Tasks:");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println(i + ": " + pendingTasks.get(i));
        }
        System.out.println("Completed Tasks:");
        for (int i = 0; i < completedTasks.size(); i++) {
            System.out.println(i + ": " + completedTasks.get(i));
        }
    }

    static void saveAndExit() {
        FileHandler.saveData(pendingTasks, PENDING_FILE);
        FileHandler.saveData(completedTasks, COMPLETED_FILE);
        System.out.println("Data saved. Exiting.");
    }
}