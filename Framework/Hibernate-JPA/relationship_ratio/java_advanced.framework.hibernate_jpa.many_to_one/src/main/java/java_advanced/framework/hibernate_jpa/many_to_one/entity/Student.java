package java_advanced.framework.hibernate_jpa.many_to_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;
    private String email;
    private long contactNumber;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


    public Student() {}

    public Student( String name, String email, long contactNumber, Project project) {
   
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
        return name;
    }

    public Project getProject() {
        return project;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", project=" + project + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, email, id, name, project);
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
		return contactNumber == other.contactNumber && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(project, other.project);
	}
}