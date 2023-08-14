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
        department = new Department(null, "Gardening");
        departmentDao.insert(department);
        System.out.println("New department successfully inserted: "+department);
        System.out.println();

        System.out.println("==== TEST 4: department update ====");
        System.out.println("Before update: ");
        department = departmentDao.findById(3);
        System.out.println(departmentDao.findById(3));
        department.setName("Clothes");
        departmentDao.update(department);
        System.out.println("After update: ");
        System.out.println(departmentDao.findById(3));
        System.out.println();
        System.out.println("==== TEST 5: department delete ====");
        System.out.print("Enter a department ID to be deleted: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department successfully deleted!");
        System.out.println();
        System.out.println("================Bonus feature================");
        System.out.println("==== TEST 6: find department by name ====");
        System.out.print("Enter department name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Department found!\n"+departmentDao.findByName(name));

        sc.close();
    }
}
