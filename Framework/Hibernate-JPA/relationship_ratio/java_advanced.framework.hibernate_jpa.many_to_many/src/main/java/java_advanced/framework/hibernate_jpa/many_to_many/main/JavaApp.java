package java_advanced.framework.hibernate_jpa.many_to_many.main;

import jakarta.persistence.*;

import java.util.*;

import java_advanced.framework.hibernate_jpa.many_to_many.entity.Project;
import java_advanced.framework.hibernate_jpa.many_to_many.entity.Student;

public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student-Project");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Projects
        Project p1 = new Project(101,"AI Chatbot","AI system");
        Project p2 = new Project(102,"Ecommerce","Online store");
        Project p3 = new Project(103,"Library System","Library software");

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // Student 1 works on two projects
        List<Project> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);

        Student s1 = new Student("Arya","arya@gmail.com",list1);

        // Student 2 works on two projects
        List<Project> list2 = new ArrayList<>();
        list2.add(p2);
        list2.add(p3);

        Student s2 = new Student("Aditi","aditi@gmail.com",list2);

        em.persist(s1);
        em.persist(s2);

        tx.commit();

        System.out.println("Insert Successful");

        /* DISPLAY */

        List<Student> students =
                em.createQuery("FROM Student",Student.class).getResultList();

        for(Student s : students){

            System.out.println("Student : " + s.getName());

            for(Project p : s.getProjects()){
                System.out.println("Project : " + p.getName());
            }

            System.out.println("---------------------");
        }

        /* UPDATE */

        tx.begin();

        Project project = em.find(Project.class,101);
        project.setDescription("Advanced AI system");

        tx.commit();

        System.out.println("Project Updated");

        /* DELETE STUDENT */

        tx.begin();

        Student student = em.find(Student.class,1);
        em.remove(student);

        tx.commit();

        System.out.println("Student Deleted");

        em.close();
        emf.close();
    }
}