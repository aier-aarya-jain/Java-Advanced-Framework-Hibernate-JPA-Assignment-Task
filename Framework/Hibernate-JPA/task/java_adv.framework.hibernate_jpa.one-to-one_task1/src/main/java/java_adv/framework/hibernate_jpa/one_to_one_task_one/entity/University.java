package java_adv.framework.hibernate_jpa.one_to_one_task_one.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class University implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityId;

    private String universityName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="college_id")
    private College college;

    public University() {}

    public University(String universityName, College college) {
        this.universityName = universityName;
        this.college = college;
    }

    public int getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(college, universityId, universityName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(college, other.college) && universityId == other.universityId
				&& Objects.equals(universityName, other.universityName);
	}
    
}