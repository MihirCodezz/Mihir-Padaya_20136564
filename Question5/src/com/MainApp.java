package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String cname = scanner.nextLine();
        
        System.out.print("Enter place: ");
        String place = scanner.nextLine();
        
        System.out.print("Enter PAN: ");
        String pan = scanner.nextLine();

        Configuration configuration = new Configuration().configure();
        
  
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        

        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
  
        Customer customer = new Customer(cname, place, pan);
        
        session.save(customer);
        
        session.getTransaction().commit();
        
        session.close();
        sessionFactory.close();
        
        System.out.println("Customer record inserted successfully!");
    }
}
