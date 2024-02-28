package view;

import manager.ComputerManager;
import manager.EmployeeManager;
import manager.UserManager;
import model.Computer;
import model.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        UserManager userManager = new UserManager();
        ComputerManager computerManager = new ComputerManager();
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
                    int choiceEmployee;
                    while (true){
                        System.out.println("Choose Action");
                        System.out.println("1: List of available computers ");
                        System.out.println("2: Add new computer");
                        System.out.println("3: Edit computer information");
                        System.out.println("4: Delete a computer");
                        System.out.println("5: Recharge");
                        System.out.println("6: Add new user");
                        System.out.println("7: List user");
                        choiceEmployee = scanner.nextInt();
                        switch (choiceEmployee){
                            case 1:
                                computerManager.display();
                                break;
                            case 2:
                                computerManager.add();
                                break;
                            case 3:
                                computerManager.edit();
                            case 4:
                                computerManager.delete();
                            case 5:
                                employeeManager.recharge();
                                break;
                            case 6:
                                userManager.add();
                                break;
                            case 7:
                                userManager.display();
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        if (choiceEmployee == 0 ){
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Login Account User");
                    userManager.loginByIDPasword();
                    int choiceUser;
                    while (true){
                        System.out.println("Choose Action");
                        System.out.println("1: Recharge Money");
                        choiceUser = scanner.nextInt();
                        switch (choiceUser){
                            case 1:
                                System.out.println("wait");
                        }
                    }
                case 0:
                    System.exit(0);
            }
        }
    }
}