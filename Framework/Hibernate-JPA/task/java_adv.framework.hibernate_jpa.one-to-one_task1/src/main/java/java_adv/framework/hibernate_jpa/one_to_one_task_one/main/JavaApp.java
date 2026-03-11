package java_adv.framework.hibernate_jpa.one_to_one_task_one.main;
import java_adv.framework.hibernate_jpa.one_to_one_task_one.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {


	    public static void execution(){

	        // Create EntityManagerFactory
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UniversityPU");

	        // Create EntityManager
	        EntityManager em = emf.createEntityManager();

	        // Transaction
	        EntityTransaction tx = em.getTransaction();

	        try {

	            // ================= CREATE =================

	            tx.begin();

	            Project project = new Project("AI Prediction System");

	            Student student = new Student("Arya Jain", project);

	            Department department = new Department("AI & ML", student);

	            College college = new College("JECRC Foundation", department);

	            University university = new University("JECRC", college);

	            em.persist(university);

	            tx.commit();

	            System.out.println("Data Inserted Successfully");


	            // ================= READ =================

	            University u = em.find(University.class, 1);

	            System.out.println("\n--- University Details ---");
	            System.out.println("University : " + u.getUniversityName());
	            System.out.println("College : " + u.getCollege().getCollegeName());
	            System.out.println("Department : " + u.getCollege().getDepartment().getDepartmentName());
	            System.out.println("Student : " + u.getCollege().getDepartment().getStudent().getStudentName());
	            System.out.println("Project : " + u.getCollege().getDepartment().getStudent().getProject().getProjectName());


	            // ================= UPDATE =================

	            tx.begin();

	            u.getCollege().getDepartment().getStudent().setStudentName("Arya Updated");

	            em.merge(u);

	            tx.commit();

	            System.out.println("\nStudent Updated");


	            // ================= DELETE =================

	            tx.begin();

	            University deleteUniversity = em.find(University.class, 1);

	            em.remove(deleteUniversity);

	            tx.commit();

	            System.out.println("\nUniversity Deleted (Cascade Applied)");

	        } 
	        catch (Exception e) {

	            if (tx.isActive()) {
	                tx.rollback();
	            }

	            e.printStackTrace();
	        } 
	        finally {

	            em.close();
	            emf.close();
	        }
	    }
	}


