package application;

import model.entities.Department;

public class Program {

    public static void main(String[] args) {
        Department department = new Department(12, "Books");
        System.out.println(department);
    }
}
