package java_adv.framework.hibernate_jpa.one_to_many_task_two.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int employeeId;

private String employeeName;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="employee_id")
private List<Project> projects;

public Employee(){}

public Employee(String employeeName, List<Project> projects){
this.employeeName = employeeName;
this.projects = projects;
}

public int getEmployeeId(){ return employeeId; }

public String getEmployeeName(){ return employeeName; }

public void setEmployeeName(String employeeName){
this.employeeName = employeeName;
}

public List<Project> getProjects(){
return projects;
}

public void setProjects(List<Project> projects){
this.projects = projects;
}

@Override
public int hashCode() {
	return Objects.hash(employeeId, employeeName, projects);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return employeeId == other.employeeId && Objects.equals(employeeName, other.employeeName)
			&& Objects.equals(projects, other.projects);
}

@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
}
}