package java_advanced.framework.hibernate_java.one_to_one.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java_advanced.framework.hibernate_java.one_to_one.entity.Project;
import java_advanced.framework.hibernate_java.one_to_one.entity.Student;

public class JavaApp {
	public static void execution() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		 // Creating Project Objects
        Project p1 = new Project(101, "AI Chatbot", "AI based chatbot system");
        Project p2 = new Project(102, "E-Commerce Website", "Online shopping platform");
        Project p3 = new Project(103, "Library Management", "Library automation system");
        Project p4 = new Project(104, "Hospital Management", "Hospital record system");
        Project p5 = new Project(105, "Student Portal", "University student portal");

        // Persist Projects
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(p4);
        entityManager.persist(p5);

        // Creating Student Objects with Project
        Student s1 = new Student(1, "Arya", "arya@gmail.com", 9876543210L, p1);
        Student s2 = new Student(2, "Rohit", "rohit@gmail.com", 9876543211L, p2);
        Student s3 = new Student(3, "Priya", "priya@gmail.com", 9876543212L, p3);
        Student s4 = new Student(4, "Aman", "aman@gmail.com", 9876543213L, p4);
        Student s5 = new Student(5, "Neha", "neha@gmail.com", 9876543214L, p5);

        // Persist Students
        entityManager.persist(s1);
        entityManager.persist(s2);
        entityManager.persist(s3);
        entityManager.persist(s4);
        entityManager.persist(s5);


        // Step 8: Commit Transaction
        entityTransaction.commit();

        System.out.println("5 Student and 5 Project details inserted successfully.");

        // Step 9: Close resources
        entityManager.close();
        
        
		System.out.println("hello World!!");
	}
}
