
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class UserInterface {

    private TodoList toDoList;
    private Scanner scanner;

    public UserInterface(TodoList toDoList, Scanner scanner) {
        this.toDoList = toDoList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }
            switch (command) {
                case "add":
                    addTask();
                    break;
                case "list":
                    listTasks();
                    break;
                case "remove":
                    removeTask();
                    break;
            }
        }
    }

    private void addTask() {
        System.out.print("To add: ");
        String task = this.scanner.nextLine();
        this.toDoList.add(task);
    }

    private void listTasks() {
        this.toDoList.print();
    }

    private void removeTask() {
        System.out.println("Which one is removed? ");
        int number = Integer.valueOf(this.scanner.nextLine());
        this.toDoList.remove(number);
    }
}
