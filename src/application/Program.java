package application;

import java.util.Date;

import javax.swing.JOptionPane;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args){

        int menu = 0;
        while(menu != 3){
            try{
                menu = Integer.parseInt(JOptionPane.showInputDialog(  "\nOpções: " + "\n1. Vendedores" + "\n2. Departamentos" + "\n3. Sair"));
                switch(menu){
                    case 1: 
                        menuVendedores();
                        break;
                    case 2: 
                        menuDepartamentos();
                        break;
                    case 3:
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    public static void menuVendedores(){
        SellerDao sd = DaoFactory.createSellerDao();
        StringBuilder sb = null;
        int id;
        Seller seller;
        int menu = 0;
        while(menu != 7){
            try{
                menu = Integer.parseInt(JOptionPane.showInputDialog( "\n1. Insert" + "\n2. Update" + "\n3. Delete" + "\n4. FindById" + "\n5. FindByDepartment" + "\n6. FindAll" + "\n7. Voltar"));
                switch(menu){
                    case 1:
                        seller = new Seller();
                        seller.setName(JOptionPane.showInputDialog("Nome:"));
                        seller.setEmail(JOptionPane.showInputDialog("E-mail:"));
                        seller.setBirthDate(new Date());
                        seller.setBaseSalary(Double.parseDouble(JOptionPane.showInputDialog( "Salário:")));
                        seller.setDepartment(new Department(Integer.parseInt(JOptionPane.showInputDialog("Departamento:")), null));
                        sd.insert(seller);
                        JOptionPane.showMessageDialog(null, "Vendedor adicionado!");
                        break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog( "Entre com um ID de vendedor para atualiza-lo:"));
                        seller = sd.findById(id);
                        seller.setName(JOptionPane.showInputDialog("Nome:"));
                        seller.setEmail(JOptionPane.showInputDialog("E-mail:"));
                        seller.setBaseSalary(Double.parseDouble(JOptionPane.showInputDialog( "Salário:")));
                        seller.setDepartment(new Department(Integer.parseInt(JOptionPane.showInputDialog("Departamento:")), null));
                        sd.update(seller);
                        JOptionPane.showMessageDialog(null, "Vendedor atualizado!");
                        break;
                    case 3:
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com um ID de vendedor para remove-lo do banco de dados:"));
                        sd.deleteById(id);
                        break;
                    case 4:
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com um ID de vendedor para busca:"));
                        seller = sd.findById(id);
                        JOptionPane.showMessageDialog(null, seller);
                        break;
                    case 5:
                        sb = new StringBuilder();
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com um ID de departamento para busca:"));
                        for(Seller s : sd.findByDepartment(new Department(id, null))) sb.append(s + "\n");
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;
                    case 6:
                        sb = new StringBuilder();
                        for(Seller s : sd.findAll()) sb.append(s + "\n");                       
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;
                    case 7:
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    public static void menuDepartamentos(){
        DepartmentDao dd = DaoFactory.createDepartmentDao();
        int menu = 0;
        while(menu != 6){
            try{
                menu = Integer.parseInt(JOptionPane.showInputDialog( "\n1. Insert" + "\n2. Update" + "\n3. Delete" + "\n4. FindById" + "\n5. FindAll" + "\n6. Voltar"));
                switch(menu){
                    case 1:
                        JOptionPane.showMessageDialog(null,"INSERT");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"UPDATE");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,"DELETE");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"FIND BY ID");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"FIND ALL");
                        break;
                    case 6:
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    /*
        //Department dp = new Department(null, "Developer");
        //dd.insert(dp);
        //System.out.println("Insert completed! New department Id: " + dp.getId());

        //dp.setName("Dev");
        //dd.update(dp);
        //System.out.println("\nUpdate completed! ");

        //System.out.print("Enter the ID to delete the department: ");
        //int id = sc.nextInt();
        //dd.deleteById(id);
        //System.out.println("Delete completed!");

        //for(Department d : dd.findAll()){
        //    System.out.println(d.getId() + " ," + d.getName());
        //}
        
        //id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id do departamento: "));
        //System.out.println(dd.findById(id));*/
}
