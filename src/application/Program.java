package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args){
        
        Department department = new Department(1, "Books");
        Seller seller = new Seller(42, "Bob Braw", "bob@gmail.com", new Date(), 4600.00, department);
        SellerDao sd = DaoFactory.createSellerDao();
        sd.insert(seller);
        System.out.println(seller);
    }
}
