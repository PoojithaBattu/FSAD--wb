package com.klu.app;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.klu.model.Product;
import com.klu.util.HibernateUtil;
public class MainApp {


    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Insert Product");
            System.out.println("2.Display Product");
            System.out.println("3.Update Product");
            System.out.println("4.Delete Product");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: insertProduct(sc); break;
                case 2: displayProduct(sc); break;
                case 3: updateProduct(sc); break;
                case 4: deleteProduct(sc); break;
                case 5: System.out.println("Thank You"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 5);

        sc.close();
        factory.close();
    }

    static void insertProduct(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product();

        System.out.print("Name: ");
        p.setName(sc.next());

        System.out.print("Description: ");
        p.setDescription(sc.next());

        System.out.print("Price: ");
        p.setPrice(sc.nextDouble());

        System.out.print("Quantity: ");
        p.setQuantity(sc.nextInt());

        session.persist(p);
        tx.commit();
        session.close();
        System.out.println("Inserted successfully");
    }

    static void displayProduct(Scanner sc) {
        Session session = factory.openSession();
        System.out.print("Enter ID: ");
        Product p = session.get(Product.class, sc.nextInt());

        if (p != null) {
            System.out.println(p.getName());
            System.out.println(p.getPrice());
            System.out.println(p.getQuantity());
        } else {
            System.out.println("Product not found");
        }
        session.close();
    }

    static void updateProduct(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter ID: ");
        Product p = session.get(Product.class, sc.nextInt());

        if (p != null) {
            System.out.print("New price: ");
            p.setPrice(sc.nextDouble());
            System.out.print("New quantity: ");
            p.setQuantity(sc.nextInt());
            tx.commit();
            System.out.println("Updated");
        } else {
            System.out.println("Not found");
            tx.rollback();
        }
        session.close();
    }

    static void deleteProduct(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter ID: ");
        Product p = session.get(Product.class, sc.nextInt());

        if (p != null) {
            session.remove(p);
            tx.commit();
            System.out.println("Deleted");
        } else {
            System.out.println("Not found");
            tx.rollback();
        }
        session.close();
    }


}
