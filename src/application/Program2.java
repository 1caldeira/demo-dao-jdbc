package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("==== TEST 1: department findById ====");
        Department department = departmentDao.findById(3);
        System.out.println(department);
        System.out.println();

        System.out.println("==== TEST 2: department findAll ====");
        List<Department> departments = departmentDao.findAll();
        for (Department dep : departments) {
            System.out.println(dep);
        }
        System.out.println();
        System.out.println("==== TEST 3: department insert ====");
        department.setId(5);
        department.setName("Jewelry");
        departmentDao.insert(department);
        System.out.println(departmentDao.findById(5));
        System.out.println();

        System.out.println("==== TEST 4: department update ====");
        System.out.println("Before update: ");
        department = departmentDao.findById(6);
        System.out.println(departmentDao.findById(6));
        System.out.println("After update: ");
        department.setName("Cosmetics");
        departmentDao.update(department);
        System.out.println(departmentDao.findById(6));

        sc.close();
    }
}
