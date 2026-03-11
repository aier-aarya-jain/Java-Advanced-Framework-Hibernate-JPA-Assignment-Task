package java_adv.framework.hibernate_jpa.one_to_many_task_two.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Branch implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;

	private String branchName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private List<Department> departments;

	public Branch() {
	}

	public Branch(String branchName, List<Department> departments) {
		this.branchName = branchName;
		this.departments = departments;
	}

	public int getBranchId() {
		return branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchId, branchName, departments);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return branchId == other.branchId && Objects.equals(branchName, other.branchName)
				&& Objects.equals(departments, other.departments);
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + "]";
	}
}