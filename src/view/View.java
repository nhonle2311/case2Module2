package view;

import manager.ComputerManager;
import manager.EmployeeManager;
import manager.UserManager;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        UserManager userManager = new UserManager();
        ComputerManager computerManager = new ComputerManager();
        while (true) {
            System.out.println("===== Choose Account Login =====");
            System.out.println("1: Employee");
            System.out.println("2: User");

            int choice;
            System.out.println("Enter Number");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Login Account Employee");
                    employeeManager.loginByIDPasword();
                    int choiceEmployee;
                    while (true) {
                        System.out.println("Choose Action");
                        System.out.println("1: List of available computers ");
                        System.out.println("2: Add new computer");
                        System.out.println("3: Edit computer information");
                        System.out.println("4: Delete a computer");
                        System.out.println("5: Recharge");
                        System.out.println("6: Add new user");
                        System.out.println("7: List user");
                        System.out.println("8: List Employee");
                        System.out.println("9: Add new employee");
                        System.out.println("0: Exit");

                        choiceEmployee = scanner.nextInt();
                        switch (choiceEmployee) {
                            case 1:
                                computerManager.display();
                                break;
                            case 2:
                                computerManager.add();
                                break;
                            case 3:
                                computerManager.edit();
                                break;
                            case 4:
                                computerManager.delete();
                                break;
                            case 5:
                                employeeManager.recharge();
                                break;
                            case 6:
                                userManager.add();
                                break;
                            case 7:
                                userManager.display();
                                break;
                            case 8:
                                employeeManager.display();
                                break;
                            case 9:
                                employeeManager.add();
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                        if (choiceEmployee == 0) {
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Login Account User");
                    userManager.loginByIDPasword();

                    int choiceUser;
                    while (true) {
                        System.out.println("Choose Action");
                        System.out.println("1: Edit Account");
                        System.out.println("2: Show Balance ");
                        System.out.println("3: Order");
                        System.out.println("4: Logout");
                        System.out.println("5: Sort by balance");
                        System.out.println("0: Back");
                        choiceUser = scanner.nextInt();
                        switch (choiceUser) {
                            case 1:
                                userManager.edit();
                                break;
                            case 2:
                                userManager.showBalance();
                                break;
                            case 3:
                                System.out.println("Choose Action");
                                System.out.println("1: Water 10000");
                                System.out.println("2: Cigarette 15000");
                                System.out.println("0: Exit");

                                int choiceOrder;
                                while (true) {
                                    choiceOrder = scanner.nextInt();
                                    switch (choiceOrder) {
                                        case 1:
                                            userManager.orderSting();
                                            break;
                                        case 2:
                                            userManager.orderCigarette();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                    }

                                    if (choiceOrder == 0) {
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                userManager.logOut();
                                break;
                            case 5:
                                userManager.sorByBalance();
                            default:
                                System.out.println("Invalid choice. Please try again.");

                        }

                        if (choiceUser == 0) {
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
