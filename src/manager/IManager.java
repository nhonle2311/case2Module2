package manager;

import model.Employee;

import java.util.List;

public interface IManager<E> {
    void display();
    void add(E e);
    void edit();

    void delete();

}
