package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch (command) {
                case "1":
                    listTasks();
                    break;
                case "2":
                    addTasks();
                    break;
                case "3":
                    markTaskAsDone();
                    break;
                case "4":
                    removeTask();
                    break;
            }
        }

        System.out.println("Thank you!");
    }

    private void listTasks() throws SQLException {
        System.out.println("Listing the database contents");
        System.out.println("");
        List<Todo> tasks = this.database.list();
        for (Todo t : tasks) {
            System.out.println(t);
        }
    }

    private void addTasks() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = this.scanner.nextLine();
        System.out.println("Enter description");
        String description = this.scanner.nextLine();
        this.database.add(new Todo(name, description, false));
    }

    private void markTaskAsDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        String id = this.scanner.nextLine();
        this.database.markAsDone(Integer.valueOf(id));
    }

    private void removeTask() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        String id = this.scanner.nextLine();
        this.database.remove(Integer.valueOf(id));
    }
}
