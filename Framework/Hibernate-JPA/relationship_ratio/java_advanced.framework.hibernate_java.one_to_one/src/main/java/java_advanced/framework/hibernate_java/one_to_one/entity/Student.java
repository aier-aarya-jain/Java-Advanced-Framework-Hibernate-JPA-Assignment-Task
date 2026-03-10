package java_advanced.framework.hibernate_java.one_to_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;
    private String email;
    private Long contactNumber;

    @OneToOne
    private Project project;

    public Student() {}

    public Student(Integer id, String name, String email, Long contactNumber, Project project) {
        Id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.project = project;
    }
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, contactNumber, email, name, project);
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
		return Objects.equals(Id, other.Id) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(project, other.project);
	}
	
	
	
	

}
