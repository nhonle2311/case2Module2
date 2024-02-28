package manager;

import model.Employee;

import java.util.List;
import java.util.Scanner;

import category.FileEmloyee;
public class EmployeeManager implements IManager<Employee>,Login{
    private final Scanner scanner = new Scanner(System.in);
    private final FileEmloyee fileEmloyee = new FileEmloyee();
    private final List<Employee> employeeList = fileEmloyee.readEmployee();

    @Override
    public void display() {
        System.out.println(employeeList);
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
        fileEmloyee.writeEmployee(employeeList);
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
        fileEmloyee.readEmployee();
        System.out.println("Enter ID");
        String Id = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        for (Employee employee: employeeList){
            if (employee.getId().equals(Id) && employee.getPass().equals(password)){
                System.out.println("Login Success");
                return true;
            }
        }
        System.out.println("ID or Password wrong");
        return false;
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }
}
