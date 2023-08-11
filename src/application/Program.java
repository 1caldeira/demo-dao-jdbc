package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println();

        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("==== TEST 2: seller findByDepartment ====");
        List<Seller> sellers;
        sellers = sellerDao.findByDepartment(seller.getDepartment());
        for (Seller obj : sellers) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("==== TEST 3: seller findAll ====");
        sellers = sellerDao.findAll();
        for (Seller obj : sellers) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null,"Greg Doucette","greg@gmail.com", new Date(),4000.0,new Department(1, null));
        sellerDao.insert(newSeller);
        System.out.println("New Seller inserted! New ID = "+newSeller.getId());
        System.out.println();

        System.out.println("==== TEST 5: seller update ====");
        seller = sellerDao.findById(9);
        System.out.println("Before Update: ");
        System.out.println(sellerDao.findById(9));
        seller.setName("Greg Grette");
        sellerDao.update(seller);
        System.out.println("Update completed!: ");
        System.out.println(sellerDao.findById(9));
        System.out.println();

        System.out.println("==== TEST 6: seller delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        System.out.println();

        System.out.println("================Bonus feature================");
        System.out.println();
        System.out.println("==== TEST 7: Update Seller Id ====");
        seller = sellerDao.findById(9);
        System.out.println("Before Update: ");
        System.out.println(sellerDao.findById(9));
        seller.setId(8);
        sellerDao.updateId(seller);
        System.out.println("Update completed!: ");
        System.out.println(sellerDao.findById(8));


        sc.close();
    }
}
