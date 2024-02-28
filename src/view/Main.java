package view;

import manager.EmployeeManager;
import manager.UserManager;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        UserManager userManager = new UserManager();
        System.out.println("===== Choose Account Login =====");
        System.out.println("1: Employee");
        System.out.println("2: User");
        System.out.println("0: Exit");
        int choice;
        while (true){
            System.out.println("Enter Number");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Login Account Employee");
                    employeeManager.loginByIDPasword();
                    break;
                case 2:
                    System.out.println("Login Account User");
                    userManager.loginByIDPasword();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}