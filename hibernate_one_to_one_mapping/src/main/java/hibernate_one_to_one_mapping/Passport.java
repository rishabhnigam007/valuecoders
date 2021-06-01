package hibernate_one_to_one_mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Passport")
public class Passport 
{
	 @Id
	    @GeneratedValue(generator="gen")
	    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property",  
	                          value="applicant"))
	    
	 	@Column(name = "Passport_Id")
	    private int passportId;
	   
	    @Column(name = "Passport_Number")
	    private String passportNumber;
	   
	    @Column(name = "Issued_Date")
	    @Temporal(TemporalType.DATE)
	    private Date issuedDate;
	   
	    @Column(name = "Expiry_Date")
	    @Temporal(TemporalType.DATE)
	    private Date expiryDate;
	   
	    @OneToOne
	    @PrimaryKeyJoinColumn
	    private Applicant applicant;
	   
	    public int getPassportId() {
	        return passportId;
	    }
	    public void setPassportId(int passportId) {
	        this.passportId = passportId;
	    }
	    public String getPassportNumber() {
	        return passportNumber;
	    }
	    public void setPassportNumber(String passportNumber) {
	        this.passportNumber = passportNumber;
	    }
	    public Date getIssuedDate() {
	        return issuedDate;
	    }
	    public void setIssuedDate(Date issuedDate) {
	        this.issuedDate = issuedDate;
	    }
	    public Date getExpiryDate() {
	        return expiryDate;
	    }
	    public void setExpiryDate(Date expiryDate) {
	        this.expiryDate = expiryDate;
	    }
	    public Applicant getApplicant() {
	        return applicant;
	    }
	    public void setApplicant(Applicant applicant) {
	        this.applicant = applicant;
	    }
	    
}