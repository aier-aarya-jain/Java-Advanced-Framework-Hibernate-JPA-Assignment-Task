package java_adv.framework.hibernate_jpa.one_to_one_task_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String studentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Project project;

    public Student() {}

    public Student(String studentName, Project project) {
        this.studentName = studentName;
        this.project = project;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

	@Override
	public int hashCode() {
		return Objects.hash(project, studentId, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(project, other.project) && studentId == other.studentId
				&& Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
}
