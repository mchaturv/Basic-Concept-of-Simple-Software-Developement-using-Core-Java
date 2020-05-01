


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mayank
 * @Bean Class defined for Employee
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	@XmlElement(name = "first_name")
	public String firstName;
	
	@XmlElement(name = "last_name")
	public String lastName; 
	
	@XmlElement(name = "office_city")
	public String officeCity;
	
	@XmlElement(name = "active_customers")
	public int activeCustomer;
	
	@XmlElement(name = "total_sales")
	public float totalShare;

	/**
	 * Default Constructor
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param firstName
	 * @param lastName
	 * @param officeCity
	 * @param activeCustomer
	 * @param totalShare
	 */
	public Employee(String firstName, String lastName, String officeCity, int activeCustomer, float totalShare) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.officeCity = officeCity;
		this.activeCustomer = activeCustomer;
		this.totalShare = totalShare;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the officeCity
	 */
	public String getOfficeCity() {
		return officeCity;
	}

	/**
	 * @param officeCity the officeCity to set
	 */
	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}

	/**
	 * @return the activeCustomer
	 */
	public int getActiveCustomer() {
		return activeCustomer;
	}

	/**
	 * @param activeCustomer the activeCustomer to set
	 */
	public void setActiveCustomer(int activeCustomer) {
		this.activeCustomer = activeCustomer;
	}

	/**
	 * @return the totalShare
	 */
	public float getTotalShare() {
		return totalShare;
	}

	/**
	 * @param totalShare the totalShare to set
	 */
	public void setTotalShare(float totalShare) {
		this.totalShare = totalShare;
	}



	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activeCustomer;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((officeCity == null) ? 0 : officeCity.hashCode());
		result = prime * result + Float.floatToIntBits(totalShare);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (activeCustomer != other.activeCustomer)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (officeCity == null) {
			if (other.officeCity != null)
				return false;
		} else if (!officeCity.equals(other.officeCity))
			return false;
		if (Float.floatToIntBits(totalShare) != Float.floatToIntBits(other.totalShare))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", officeCity=" + officeCity
				+ ", activeCustomer=" + activeCustomer + ", totalShare=" + totalShare + "]";
	}

	
	
	

}
