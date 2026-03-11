package java_adv.framework.hibernate_jpa.one_to_one_task_one.entity;


import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    private String departmentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;

    public Department() {}

    public Department(String departmentName, Student student) {
        this.departmentName = departmentName;
        this.student = student;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}