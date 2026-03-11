package java_adv.framework.hibernate_jpa.one_to_many_task_two.main;

import java_adv.framework.hibernate_jpa.one_to_many_task_two.entity.*;
import jakarta.persistence.*;
import java.util.*;

public class JavaApp {

	public static void execution() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompanyPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			// ---------- PROJECT ----------
			Project p1 = new Project("AI System");
			Project p2 = new Project("Data Pipeline");

			List<Project> projectList = new ArrayList<>();
			projectList.add(p1);
			projectList.add(p2);

			// ---------- EMPLOYEE ----------
			Employee e1 = new Employee("Arya", projectList);

			List<Employee> employeeList = new ArrayList<>();
			employeeList.add(e1);

			// ---------- DEPARTMENT ----------
			Department d1 = new Department("IT", employeeList);

			List<Department> departmentList = new ArrayList<>();
			departmentList.add(d1);

			// ---------- BRANCH ----------
			Branch b1 = new Branch("Jaipur Branch", departmentList);

			List<Branch> branchList = new ArrayList<>();
			branchList.add(b1);

			// ---------- COMPANY ----------
			Company company = new Company("Tech Corp", branchList);

			em.persist(company);

			tx.commit();

			System.out.println("DATA INSERTED");

			// ---------------- READ ----------------

			Company c = em.find(Company.class, 1);

			System.out.println("Company: " + c.getCompanyName());

			for (Branch b : c.getBranches()) {
				System.out.println("Branch: " + b.getBranchName());

				for (Department d : b.getDepartments()) {
					System.out.println("Department: " + d.getDepartmentName());

					for (Employee e : d.getEmployees()) {
						System.out.println("Employee: " + e.getEmployeeName());

						for (Project p : e.getProjects()) {
							System.out.println("Project: " + p.getProjectName());
						}
					}
				}
			}

			// ---------------- UPDATE ----------------

			tx.begin();

			c.setCompanyName("Tech Corp Updated");

			em.merge(c);

			tx.commit();

			System.out.println("UPDATED");

			// ---------------- DELETE ----------------

			tx.begin();

			Company deleteCompany = em.find(Company.class, 1);

			em.remove(deleteCompany);

			tx.commit();

			System.out.println("DELETED WITH CASCADE");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			em.close();
			emf.close();
		}
	}
}