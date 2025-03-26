package com.hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class tester {
    public static void main(String[] args) {
        // Step 1: Load Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Step 2: Create session factory and open session
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Step 3: Start transaction
        Transaction transaction = session.beginTransaction();

        // Step 4: Insert data
        Employee emp1 = new Employee();
        emp1.setName("John Doe");

        Employee emp2 = new Employee();
        emp2.setName("Alice");

        Employee emp3 = new Employee();
        emp3.setName("Bob");

        Employee emp4 = new Employee();
        emp4.setName("Surya");

        // Save employees
        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        session.save(emp4);

        // Commit transaction
        transaction.commit();
        System.out.println("Data inserted successfully!");

        // Step 5: Retrieve and display all employees
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName());
        }

        // Close session
        session.close();
    }
}