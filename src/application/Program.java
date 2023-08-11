package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("==== TEST 2: seller findByDepartment ====");
        List<Seller> sellers;
        sellers = sellerDao.findByDepartment(seller.getDepartment());
        for (Seller obj : sellers) {
            System.out.println(obj);
        }
        System.out.println("==== TEST 3: seller findAll ====");
        sellers = sellerDao.findAll();
        for (Seller obj : sellers) {
            System.out.println(obj);
        }
        System.out.println("==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null,"Greg Doucette","greg@gmail.com", new Date(),4000.0,new Department(1, null));
        sellerDao.insert(newSeller);
        System.out.println("New Seller inserted! New ID = "+newSeller.getId());

    }
}
