


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mayank
 * @Bean Class defined for Address
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@XmlElement(name = "street_address")
	public String streetAddress;
	
	
	@XmlElement(name = "city")
	public String city;
	public String state;
	
	
	@XmlElement(name = "postal_code")
	public String postalCode;
	
	
	@XmlElement(name = "country")
	public String country;
	
	
	
	/**
	 * Default Constructor
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param country
	 */
	public Address(String streetAddress, String city, String state, String postalCode, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}






	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [ streetAddress="
				+ streetAddress + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country="
				+ country + "]";
	}
	
	

}
