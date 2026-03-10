package java_advanced.framework.hibernate_jpa.one_to_many.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Project implements Serializable {

    @Id
    private Integer id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<StudentProject> studentProjects;

    public Project() {}

    public Project(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", studentProjects="
				+ studentProjects + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, studentProjects);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(studentProjects, other.studentProjects);
	}
    
}