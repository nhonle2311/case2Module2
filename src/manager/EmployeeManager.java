package manager;

import category.FileUser;
import model.Employee;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import category.FileEmloyee;
import model.User;

public class EmployeeManager implements IManager,Login{
    private final Scanner scanner = new Scanner(System.in);
    private final FileEmloyee fileEmloyee = new FileEmloyee();
    private final List<Employee> employeeList = fileEmloyee.readEmployee();
    private final FileUser fileUser = new FileUser();
    private final List<User> userList = fileUser.readFileUser();
    private Employee loggedEmployee = null;
    @Override
    public void display() {
        System.out.println(employeeList);
    }

    @Override
    public void add() {
        while (true){
            try {
                System.out.println("Enter new employee details:");
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Phone: ");
                int phone = Integer.parseInt(scanner.nextLine());
                System.out.print("Password: ");
                String password = scanner.nextLine();

                Employee newEmployee = new Employee(id, name, email, phone, password);
                employeeList.add(newEmployee);
                fileEmloyee.writeEmployee(employeeList);
                break;
            }catch (Exception e){
                System.out.println("Pleas Enter Again");
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter Id");
        String inputID = scanner.nextLine();
        for (Employee employee1 : employeeList){
            if (employee1.getId().equals(inputID)){
                System.out.println("Enter Id");
                employee1.setId(scanner.nextLine());
                System.out.println("Enter Name");
                employee1.setName(scanner.nextLine());
                System.out.println("Enter Email");
                employee1.setEmail(scanner.nextLine());
                System.out.println("Enter Phone");
                employee1.setPhone(Integer.parseInt(scanner.nextLine()));
                 System.out.println("Enter Pass");
                employee1.setPass(scanner.nextLine());
                fileEmloyee.writeEmployee(employeeList);
            }
        }
    }


    @Override
    public void delete() {
        System.out.println("Enter ID");
        String inputId = scanner.nextLine();
        for (Employee employee : employeeList){
            if (employee.getId().equals(inputId)){
                employeeList.remove(employee);
                fileEmloyee.writeEmployee(employeeList);
            }else {
                System.out.println("Not Find");
            }
        }
    }
    @Override
    public boolean loginByIDPasword() {
        while (true) {
            fileEmloyee.readEmployee();
            System.out.println("Enter ID");
            String Id = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            for (Employee employee : employeeList) {
                if (employee.getId().equals(Id) && employee.getPass().equals(password)) {
                    System.out.println("Login Success");
                    loggedEmployee = employee;
                    return true;
                }
            }
            System.out.println("ID or Password wrong. Please try again.");
        }
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }
    public void recharge(){
        System.out.println("Enter Id User to Recharge");
        String id = scanner.nextLine();
        boolean find = false;

        for (User user: userList){
            if (user.getId().equals(id)){
                System.out.println("Enter Amount To Recharge");
                double amount = scanner.nextDouble();
                user.setBalance(user.getBalance()+amount);
                System.out.println("Recharge successful. New balance for user " + user.getName() + ": " + user.getBalance());
                fileUser.writeUserFile(userList);
                fileUser.readFileUser();
                find = true;
                break;
            }
        }
        if (!find){
            System.out.println("User Not Find");
        }
    }



    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.add();
    }


}
