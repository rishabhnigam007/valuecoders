package hibernate_many_to_many_mapping;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="Customer_Id")
	private int customerId;
	
	@Column(name = "Name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "Email", unique = true ,nullable = false)
	private String email;
	
	@Column(name = "Mobile_No", length = 10 , unique = true, nullable = false)
	private long mobileNo;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "customers")
	private Set<Bank> banks;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}	
}