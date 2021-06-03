package hibernate_cascading_strategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address
{
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Address_Id")
    private int addressId;
   
    @Column(name = "Street")
    private String street;
   
    @Column(name = "City")
    private String city;
   
    @Column(name = "Zipcode")
    private String zipcode;
   
    @ManyToOne
    @JoinColumn(name="Applicant_Id")
    private ApplicantDetail applicant;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public ApplicantDetail getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantDetail applicant) {
		this.applicant = applicant;
	}
}