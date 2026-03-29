import java.io.*;
import java.util.*;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String title, String priority) {
        tasks.add(new Task(title, priority));
        saveTasks();
        System.out.println("Task added!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveTasks();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + "," + task.getPriority() + "," + task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0], parts[1]);
                if (parts[2].equals("true")) {
                    task.markCompleted();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            // ignore first run
        }
    }
}