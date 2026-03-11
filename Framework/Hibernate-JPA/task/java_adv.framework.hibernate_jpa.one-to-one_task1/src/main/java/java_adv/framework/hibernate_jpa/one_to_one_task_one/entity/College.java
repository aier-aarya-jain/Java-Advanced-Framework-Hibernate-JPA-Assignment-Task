package java_adv.framework.hibernate_jpa.one_to_one_task_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class College implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegeId;

    private String collegeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Department department;

    public College() {}

    public College(String collegeName, Department department) {
        this.collegeName = collegeName;
        this.department = department;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

	@Override
	public int hashCode() {
		return Objects.hash(collegeId, collegeName, department);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		return collegeId == other.collegeId && Objects.equals(collegeName, other.collegeName)
				&& Objects.equals(department, other.department);
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + "]";
	}
}