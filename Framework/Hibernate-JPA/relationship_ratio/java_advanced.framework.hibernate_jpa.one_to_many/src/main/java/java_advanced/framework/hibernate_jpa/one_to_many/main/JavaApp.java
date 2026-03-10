package java_advanced.framework.hibernate_jpa.one_to_many.main;

import jakarta.persistence.*;

import java.util.*;

import java_advanced.framework.hibernate_jpa.one_to_many.entity.*;

public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student-Project-StudentProject");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Create Student
        Student s1 = new Student(1,"Arya", "aarya@gmail.com", 9876543210L);
        Student s2 = new Student(2,"Aditi", "aditi@gmail.com", 9996543210L);

        // Create Projects
        Project p1 = new Project(101, "AI Chatbot", "AI system");
        Project p2 = new Project(102, "Ecommerce", "Shopping site");
        Project p3 = new Project(103, "Library System", "Library management");

        // Create StudentProject mappings
        StudentProject sp1 = new StudentProject(s1, p1);
        StudentProject sp2 = new StudentProject(s2, p2);
        StudentProject sp3 = new StudentProject(s1, p3);

        // Persist data
        em.persist(s1);
        em.persist(s2);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        em.persist(sp1);
        em.persist(sp2);
        em.persist(sp3);

        tx.commit();

        System.out.println("Student and Project mapping inserted successfully.");

        em.close();
        emf.close();
    }
}