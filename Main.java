import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n--- Smart Student Task Planner ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();

                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    manager.addTask(task, priority);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task index: ");
                    int index1 = sc.nextInt();
                    manager.markTaskCompleted(index1);
                    break;

                case 4:
                    System.out.print("Enter task index: ");
                    int index2 = sc.nextInt();
                    manager.deleteTask(index2);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}