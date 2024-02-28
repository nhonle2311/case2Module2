package category;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileComputer {
    private final List<Computer> computers = new ArrayList<>();
    private final String fileComputer = "C:\\Users\\THINKPAD\\Documents\\CodeGym\\module2-2\\Arr\\Case2Module2\\computer.csv";
    public List<Computer> readComputer(){
        try {
            File file = new File(fileComputer);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data =line.split(",");
                Computer computer = new Computer();
                computer.setNumber(Integer.parseInt(data[0]));
                computer.setAvailable(Boolean.parseBoolean(data[1]));
                computers.add(computer);
            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return computers;
    }
    public void writeComputer(List<Computer> computers){
        try {
            File file = new File(fileComputer);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Computer computer: computers){
                bufferedWriter.write(computer.getNumber()+"," + computer.isAvailable());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
