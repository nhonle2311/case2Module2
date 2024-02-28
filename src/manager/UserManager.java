package manager;

import category.FileUser;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements IManager,Login {
    private final FileUser fileUser = new FileUser();
    private final List<User> userList = fileUser.readFileUser() ;
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println(userList);
    }

    @Override
    public void add() {
        System.out.println("Enter new user details:");
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
        System.out.println("Balance: ");
        double balance = scanner.nextDouble();
        User newUser = new User(id, name, email, phone, password,balance);
        userList.add(newUser);
        fileUser.writeUserFile(userList);
    }

    @Override
    public void edit() {
        System.out.println("Enter ID");
        String id = scanner.nextLine();
        boolean find = false;
        for (User user: userList){
            if (user.getId().equals(id)){
                System.out.println("Enter ID");
                user.setId(scanner.nextLine());
                System.out.println("Enter Name");
                user.setName(scanner.nextLine());
                System.out.println("Enter Email");
                user.setEmail(scanner.nextLine());
                System.out.println("Enter Phone");
                user.setPhone(Integer.parseInt(scanner.nextLine()));
                System.out.println("Enter Pass");
                user.setPass(scanner.nextLine());
                fileUser.writeUserFile(userList);
                System.out.println("Edit success");
                break;
            }
        }
        if (!find){
            System.out.println("Id " + id+" Not Find");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter Id");
        String ID = scanner.nextLine();
        boolean find = false;
        for (User user : userList) {
            if (user.getId().equals(ID)) {
                userList.remove(user);
                fileUser.writeUserFile(userList);
                System.out.println("delete success");
            }
        }
        if (!find){
            System.out.println("id not found");
        }
    }
    @Override
    public boolean loginByIDPasword() {
        fileUser.readFileUser();
        System.out.println("Enter Id");
        String Id = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        for (User user : userList){
            if (user.getId().equals(Id) && user.getPass().equals(password)){
                if (user.getBalance() > 0){
                    System.out.println("Login Success");
                    return true;
                }else {
                    System.out.println("Insufficient balance. Please recharge your account");
                    return false;
                }
            }
        }
        System.out.println("ID or Password Wrong");
        return false;
    }


    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }


    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.loginByIDPasword();
    }
}
