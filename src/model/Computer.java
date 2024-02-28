package model;

public class Computer {
    private int number;
    private boolean available;

    public Computer() {
    }

    public Computer(int number, boolean available) {
        this.number = number;
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "number=" + number +
                ", available=" + available +
                '}';
    }
}
