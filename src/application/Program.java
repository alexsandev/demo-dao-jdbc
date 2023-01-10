package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        SellerDao sd = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: Seller findById ====");
        Seller seller = sd.findById(4);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: Seller findByDepartment ====");
        List<Seller> list = sd.findByDepartment(new Department(2, "Electronics"));
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 3: Seller findAll ====");
        list = sd.findAll();
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 4: Seller insert ====");
        Seller newSeller = new Seller(null, "João Pereira", "joaop@gmail.com", new Date(), 3060.00, new Department(2, "Electronics"));
        sd.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n==== TEST 4: Seller insert ====");
        seller = sd.findById(5);
        seller.setBaseSalary(8000.00);
        sd.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n==== TEST 6: Seller delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sd.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
