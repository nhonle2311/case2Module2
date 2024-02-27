package readWriteFile;

import Model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEmloyee {
    private final List<Employee> employees = new ArrayList<>();
    private final String fileEmployee = "C:\\Users\\THINKPAD\\Documents\\CodeGym\\module2-2\\Arr\\Case2Module2\\employee.csv";

    public List<Employee> readEmployee(){
        try {
            File file = new File(fileEmployee);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                Employee employee = new Employee();
                employee.setId(data[0]);
                employee.setName(data[1]);
                employee.setEmail(data[2]);
                employee.setPhone(Integer.parseInt(data[3]));
                employee.setPass(data[4]);
                employees.add(employee);
            }
            bufferedReader.close();

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public void writeEmployee(List<Employee> employees){
        try {
            File file = new File(fileEmployee);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employees){
                bufferedWriter.write(employee.getId()+","+employee.getName()+","+employee.getEmail()+","+employee.getPhone()+","+employee.getPass());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileEmloyee fileEmloyee = new FileEmloyee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("A1","nhon","a",2,"alo"));
        fileEmloyee.writeEmployee(employeeList);



    }
}
