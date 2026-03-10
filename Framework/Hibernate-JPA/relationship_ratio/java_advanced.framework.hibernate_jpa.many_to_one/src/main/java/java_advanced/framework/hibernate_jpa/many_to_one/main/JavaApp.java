package java_advanced.framework.hibernate_jpa.many_to_one.main;

import jakarta.persistence.*;

import java.util.List;

import java_advanced.framework.hibernate_jpa.many_to_one.entity.Project;
import java_advanced.framework.hibernate_jpa.many_to_one.entity.Student;

public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student-Project");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        
        tx.begin();

        Project p1 = new Project(101, "AI Chatbot", "AI based chatbot system");

        em.persist(p1);

        Student s1 = new Student( "Arya", "arya@gmail.com", 9876543210L, p1);
        Student s2 = new Student( "Aditi", "aditi@gmail.com", 9876543211L, p1);
        Student s3 = new Student( "Rahul", "rahul@gmail.com", 9876543212L, p1);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        tx.commit();

        System.out.println("Insert Operation Completed");


        

        List<Student> students =
                em.createQuery("FROM Student", Student.class).getResultList();

        for (Student s : students) {

            System.out.println("Student ID : " + s.getId());
            System.out.println("Student Name : " + s.getName());
            System.out.println("Project Name : " + s.getProject().getName());
            System.out.println("---------------------------");
        }

        tx.begin();

        Project project = em.find(Project.class, 101);

        project.setName("AI Assistant");
        project.setDescription("Advanced AI System");

        tx.commit();

        System.out.println("Project Updated");
        
        tx.begin();

        Student student = em.find(Student.class, 2);

        student.setName("Aditi Sharma");
        student.setEmail("aditi.sharma@gmail.com");

        tx.commit();

        System.out.println("Student Updated");


 
        tx.begin();

        Student deleteStudent = em.find(Student.class, 1);

        em.remove(deleteStudent);
         deleteStudent = em.find(Student.class, 2);

        em.remove(deleteStudent);
         deleteStudent = em.find(Student.class, 3);

        em.remove(deleteStudent);

        tx.commit();

        System.out.println("Student Deleted");


        

        tx.begin();

        Project deleteProject = em.find(Project.class, 101);

        em.remove(deleteProject);

        tx.commit();

        System.out.println("Project Deleted");


        em.close();
        emf.close();
    }
}