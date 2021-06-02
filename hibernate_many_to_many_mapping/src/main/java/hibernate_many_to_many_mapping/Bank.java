package hibernate_many_to_many_mapping;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bank")
public class Bank 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Bank_Id")
	private int bankId;
	
	@Column(name = "Name" ,length = 20, nullable = false)
	private String name;
	
	@Column(name = "Branch_Name", length = 50, nullable = false)
	private String branchName;
	
	@Column(name = "Swift_Code" , length = 12 , nullable = false)
	private String swiftCode;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Bank_Customer", 
				joinColumns = { @JoinColumn(name ="Bank_Id", nullable = false)}, 
				inverseJoinColumns = {@JoinColumn(name ="Customer_Id", nullable = false) } )
	private Set<Customer> customers;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}