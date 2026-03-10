package java_advanced.framework.hibernate_jpa.one_to_many.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_project")
public class StudentProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // Default Constructor
    public StudentProject() {
    }

    // Parameterized Constructor
    public StudentProject(Student student, Project project) {
        this.student = student;
        this.project = project;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Project getProject() {
        return project;
    }

    // Setters
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}