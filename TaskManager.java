import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<String> pendingTasks;
    private ArrayList<String> completedTasks;
    private final String pendingFile = "pending_tasks.txt";
    private final String completedFile = "completed_tasks.txt";

    public TaskManager() {
        pendingTasks = FileHandler.loadData(pendingFile);
        completedTasks = FileHandler.loadData(completedFile);
    }

    public void addTask(Scanner scanner) {
        System.out.print("Enter new task: ");
        scanner.nextLine();
        String task = scanner.nextLine();
        pendingTasks.add(task);
        System.out.println("Task added.");
    }

    public void completeTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        viewTasks();
        System.out.print("Enter index of task to complete: ");
        int index = InputValidator.getUserInput();
        try {
            String task = pendingTasks.remove(index);
            completedTasks.add(task);
            System.out.println("Task completed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    public void viewTasks() {
        System.out.println("Pending Tasks:");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println(i + ": " + pendingTasks.get(i));
        }
        System.out.println("Completed Tasks:");
        for (int i = 0; i < completedTasks.size(); i++) {
            System.out.println(i + ": " + completedTasks.get(i));
        }
    }

    public void saveData() {
        FileHandler.saveData(pendingTasks, pendingFile);
        FileHandler.saveData(completedTasks, completedFile);
        System.out.println("Data saved.");
    }
}