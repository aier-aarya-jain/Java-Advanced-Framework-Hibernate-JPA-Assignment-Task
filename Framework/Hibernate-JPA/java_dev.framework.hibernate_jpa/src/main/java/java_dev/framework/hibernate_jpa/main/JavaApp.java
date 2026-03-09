package java_dev.framework.hibernate_jpa.main;
import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java_dev.framework.hibernate_jpa.entity.Student;
import java_dev.framework.hibernate_jpa.entity.Employee;

public class JavaApp {
/*	public static void studentExecution() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Raja");
		s1.setEmail("raja@gmail.com");
		s1.setContactNumber(9530068726L);
	
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Rani");
		s2.setEmail("rani@gmail.com");
		s2.setContactNumber(9530068726L);
				
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Ravi");
		s3.setEmail("ravi@gmail.com");
		s3.setContactNumber(9530068726L);
		
		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Ram");
		s4.setEmail("ram@gmail.com");
		s4.setContactNumber(9530068726L);
		
	//	entityManager.persist(s4);
	
		Student s = entityManager.find(Student.class, 1);
		if(s != null) {
			System.out.println(s);
			s.setEmail("King@gmail.com");
			s.setContactNumber(9509638278l);
			entityManager.merge(s);
			System.out.println("Student Data Updated Successfully");
		}
		else {
			System.out.println("Student Data Not Found");
		}
		
		
		Student data = entityManager.find(Student.class, 1);
		if(data != null) {
			entityManager.remove(data);
			System.out.println("Student Data Deleted Successfully");
		}
		else {
			System.out.println("Student Data Not Found");
		}
		
		
		
		
		entityTransaction.commit();
		
		
		
		entityManager.close();
		System.out.println(entityManager);
		System.out.println("Hello World!!");
	}
	*/
	
	public static void employeeExecution() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");

	     EntityManager em = emf.createEntityManager();

	     EntityTransaction et = em.getTransaction();
	
		 Scanner sc = new Scanner(System.in);
         System.out.print("How many employees you want to insert: ");
         int count = sc.nextInt();

         et.begin();

         for (int i = 1; i <= count; i++) {

              System.out.println("\nEnter details for Employee " + i);

              System.out.print("Enter ID: ");
              int id = sc.nextInt();

              sc.nextLine();
              System.out.print("Enter Name: ");
              String name = sc.nextLine();
              System.out.print("Enter Email: ");
              String email = sc.nextLine();

              System.out.print("Enter Contact Number: ");
              long contact = sc.nextLong();

              Employee emp = new Employee(id, name, email, contact);

              em.persist(emp);
             }

                 
             System.out.println("Employees inserted successfully");

                  
             System.out.print("Enter Employee ID to update: ");
             int updateId = sc.nextInt();

             Employee empUpdate = em.find(Employee.class, updateId);
             if (empUpdate != null) {

             sc.nextLine();

                       

             System.out.print("Enter new Email: ");
             String email = sc.nextLine();

             
             empUpdate.setEmail(email);
                      
             System.out.println("Employee updated successfully");
             } 
             else {

                   System.out.println("Employee not found");
              }


             System.out.print("Enter Employee ID to delete: ");
             int deleteId = sc.nextInt();

             Employee empDelete = em.find(Employee.class, deleteId);

             if (empDelete != null) {
                    em.remove(empDelete);

                    System.out.println("Employee deleted successfully");
                   
             } 
             else {

                    System.out.println("Employee not found");
             }

                   

             System.out.print("Enter Employee ID to display: ");
             int displayId = sc.nextInt();
             Employee empDisplay = em.find(Employee.class, displayId);

             if (empDisplay != null) {

                  System.out.println(empDisplay);

             }
             else {

                  System.out.println("Employee not found");
             }
             
             et.commit();


             System.out.println("Exiting program...");
             em.close();
             sc.close();
                            
       
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
       
/*	public static void employeeExecution() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");

	     EntityManager em = emf.createEntityManager();

	     EntityTransaction et = em.getTransaction();
	
		 Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE CRUD MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("How many employees you want to insert: ");
                    int count = sc.nextInt();

                    et.begin();

                    for (int i = 1; i <= count; i++) {

                        System.out.println("\nEnter details for Employee " + i);

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Contact Number: ");
                        long contact = sc.nextLong();

                        Employee emp = new Employee(id, name, email, contact);

                        em.persist(emp);
                    }

                    et.commit();

                    System.out.println("Employees inserted successfully");

                    break;

                case 2:

                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();

                    Employee empUpdate = em.find(Employee.class, updateId);

                    if (empUpdate != null) {

                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter new Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter new Contact: ");
                        long contact = sc.nextLong();

                        et.begin();

                        empUpdate.setName(name);
                        empUpdate.setEmail(email);
                        empUpdate.setContactNumber(contact);

                        et.commit();

                        System.out.println("Employee updated successfully");
                    } else {

                        System.out.println("Employee not found");
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    Employee empDelete = em.find(Employee.class, deleteId);

                    if (empDelete != null) {

                        et.begin();

                        em.remove(empDelete);

                        et.commit();

                        System.out.println("Employee deleted successfully");
                    } else {

                        System.out.println("Employee not found");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID to display: ");
                    int displayId = sc.nextInt();

                    Employee empDisplay = em.find(Employee.class, displayId);

                    if (empDisplay != null) {

                        System.out.println(empDisplay);

                    } else {

                        System.out.println("Employee not found");
                    }

                    break;

                case 5:

                    System.out.println("Exiting program...");
                    em.close();
                    emf.close();
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid choice");

            }
		
        }
	}
}*/
