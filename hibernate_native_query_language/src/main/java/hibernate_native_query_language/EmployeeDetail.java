package hibernate_native_query_language;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeDetail")
public class EmployeeDetail
{
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Employee_Id")
    private int employeeId;
   
    @Column(name = "FirstName")
    private String firstName;
   
    @Column(name = "LastName")
    private String lastName;
   
    @Column(name = "Age")
    private int age;
   
    @Column(name = "Education")
    private String education;
   
    @Column(name = "Salary")
    private int salary;
   
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
	public EmployeeDetail(int employeeId, String firstName, String lastName, int age, String education, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.education = education;
		this.salary = salary;
	}
	public EmployeeDetail() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeDetail [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", education=" + education + ", salary=" + salary + "]";
	}
}