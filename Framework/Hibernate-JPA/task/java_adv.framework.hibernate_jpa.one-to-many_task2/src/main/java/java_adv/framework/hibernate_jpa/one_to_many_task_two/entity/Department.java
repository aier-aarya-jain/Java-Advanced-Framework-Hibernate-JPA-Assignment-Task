package java_adv.framework.hibernate_jpa.one_to_many_task_two.entity;



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Department implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int departmentId;

private String departmentName;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="department_id")
private List<Employee> employees;

public Department(){}

public Department(String departmentName, List<Employee> employees){
this.departmentName = departmentName;
this.employees = employees;
}

public int getDepartmentId(){ return departmentId; }

public String getDepartmentName(){ return departmentName; }

public void setDepartmentName(String departmentName){
this.departmentName = departmentName;
}

public List<Employee> getEmployees(){
return employees;
}

public void setEmployees(List<Employee> employees){
this.employees = employees;
}

@Override
public int hashCode() {
	return Objects.hash(departmentId, departmentName, employees);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Department other = (Department) obj;
	return departmentId == other.departmentId && Objects.equals(departmentName, other.departmentName)
			&& Objects.equals(employees, other.employees);
}

@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
}
}