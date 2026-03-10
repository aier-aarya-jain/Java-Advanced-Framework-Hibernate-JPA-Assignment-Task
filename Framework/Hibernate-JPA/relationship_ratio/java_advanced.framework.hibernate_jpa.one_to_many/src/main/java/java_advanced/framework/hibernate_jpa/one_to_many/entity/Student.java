package java_advanced.framework.hibernate_jpa.one_to_many.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Student implements Serializable {

   @Id
    private Integer id;

    private String name;
    private String email;
    private Long contactNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentProject> student_Projects;

    public Student() {}

    public Student(Integer id ,String name, String email, Long contactNumber) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        
    }

    public Integer getId() {
        return id;
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

	public void setId(Integer id) {
		this.id = id;
	}


   public List<StudentProject> getStudentProjects() {
        return student_Projects;
    }

    public void setStudentProjects(List<StudentProject> studentProjects) {
        this.student_Projects = studentProjects;
    }

    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, email, id, name, student_Projects);
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
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(student_Projects, other.student_Projects);
	}

}