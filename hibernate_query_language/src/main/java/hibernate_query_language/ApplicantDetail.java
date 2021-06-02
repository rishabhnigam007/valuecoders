package hibernate_query_language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}