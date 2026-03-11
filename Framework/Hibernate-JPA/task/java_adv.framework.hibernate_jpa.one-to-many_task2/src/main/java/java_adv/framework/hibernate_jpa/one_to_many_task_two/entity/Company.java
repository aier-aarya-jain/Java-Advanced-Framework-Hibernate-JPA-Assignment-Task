package java_adv.framework.hibernate_jpa.one_to_many_task_two.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	private String companyName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private List<Branch> branches;

	public Company() {
	}

	public Company(String companyName, List<Branch> branches) {
		this.companyName = companyName;
		this.branches = branches;
	}

	public int getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branches, companyId, companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(branches, other.branches) && companyId == other.companyId
				&& Objects.equals(companyName, other.companyName);
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
}