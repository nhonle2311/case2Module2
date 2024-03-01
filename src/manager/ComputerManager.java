package manager;
import category.FileComputer;
import model.Computer;

import java.util.List;
import java.util.Scanner;

public class ComputerManager implements IManager {
        private final Scanner scanner = new Scanner(System.in);
        private final FileComputer fileComputer = new FileComputer();
        private final List<Computer> computers = fileComputer.readComputer();

        @Override
        public void display() {
            System.out.println(computers);
        }

        @Override
        public void add() {
            System.out.println("Enter Info Computer");
            System.out.println("Enter Seri Number");
            computers.add(new Computer(scanner.nextInt(),false));
            fileComputer.writeComputer(computers);
            System.out.println("Add success");
        }


        @Override
        public void edit() {
            System.out.println("Enter Number Computer Need Edit");
            int number = scanner.nextInt();
            boolean find = false;
            for (Computer computer : computers) {
                if (computer.getNumber() == number) {
                    System.out.println("Number Computer");
                    computer.setNumber(scanner.nextInt());
                    System.out.println("Status");
                    computer.setAvailable(scanner.nextBoolean());
                    fileComputer.writeComputer(computers);
                    find = true; // Đặt biến find thành true khi tìm thấy máy tính cần sửa đổi
                    break;
                }
            }
            if (!find) {
                System.out.println("Not Find Computer");
            }
        }

        @Override
        public void delete() {
            System.out.println("Enter Number Computer Need Delete");
            int number = scanner.nextInt();
            boolean find = false;
            for (int i = computers.size() - 1; i >= 0; i--) {
                if (computers.get(i).getNumber() == number) {
                    computers.remove(i);
                    fileComputer.writeComputer(computers);
                    find = true;
                    break;
                }
            }
            if (!find) {
                System.out.println("Not Find computer");
            }
        }
}
