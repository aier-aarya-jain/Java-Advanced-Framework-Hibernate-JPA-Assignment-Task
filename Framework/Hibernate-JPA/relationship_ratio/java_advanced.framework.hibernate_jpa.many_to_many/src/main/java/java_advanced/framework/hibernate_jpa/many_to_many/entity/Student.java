package java_advanced.framework.hibernate_jpa.many_to_many.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
        name = "student_project",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Student() {}

    public Student(String name, String email, List<Project> projects) {
        this.name = name;
        this.email = email;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, projects);
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
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(projects, other.projects);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }
}