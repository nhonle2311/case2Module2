package category;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUser {
    private final List<User> users = new ArrayList<>();
    private final String fileUser = "C:\\Users\\THINKPAD\\Documents\\CodeGym\\module2-2\\Arr\\Case2Module2\\user.csv";
    public List<User> readFileUser (){
        try {
            File file = new File(fileUser);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                User user = new User();
                user.setId(data[0]);
                user.setName(data[1]);
                user.setEmail(data[2]);
                user.setPhone(Integer.parseInt(data[3]));
                user.setPass(data[4]);
                users.add(user);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public void writeUserFile(List<User> users){
        try {
            File file = new File(fileUser);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user: users){
                bufferedWriter.write(user.getId()+","+user.getName()+","+user.getEmail()+","+user.getPhone()+","+user.getPass());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
