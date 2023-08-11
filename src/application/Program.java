package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

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

    }
}
