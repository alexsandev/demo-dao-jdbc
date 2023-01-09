package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args){
        
        SellerDao sd = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: Seller findById ====");
        Seller seller = sd.findById(4);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: Seller findByDepartment ====");
        List<Seller> list = sd.findByDepartment(new Department(2, "Electronics"));
        list.forEach(System.out::println);
    }
}
