package hibernate_cascading_strategy;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "ApplicantDetail")
public class ApplicantDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Applicant_Id")
	private int applicantId;
	
	@Column(name = "FirstName",length = 20,nullable = false)
	private String firstName;
	
	@Column(name = "LastName",length = 20,nullable = false)
	private String lastName;
	
	@Column(name = "Age", nullable = false)
	private int age;
	
	@Column(name = "Education")
	private String education;
	
	@OneToMany(mappedBy = "applicant")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Address> addresses;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}	
}