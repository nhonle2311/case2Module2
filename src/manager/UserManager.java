package manager;

import category.FileUser;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IManager {
    private final FileUser fileUser = new FileUser();
    private final List<User> userList = fileUser.readFileUser() ;
    @Override
    public void display() {
        System.out.println(userList);
    }

    @Override
    public void add(Object o) {
        userList.add((User) o);
        fileUser.writeUserFile(userList);
    }

    @Override
    public void edit(String Id, Object o) {

    }

    @Override
    public void delete(String Id) {

    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.add(new User("A2","nhon","alo",4,"blo"));
    }
}
