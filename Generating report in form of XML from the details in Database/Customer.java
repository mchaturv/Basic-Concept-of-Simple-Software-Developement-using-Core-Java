

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;

/**
 * @author Mayank
 * @Bean Class defined for Customer
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

	@XmlTransient
	public int customerNumber;
	
	@XmlElement(name = "customer_name")
	public String customerName;
	
	
	@XmlElement(name = "address")
	public Address address;
	
	@XmlTransient
	public int salesRepEmployeeNumber;
	
	
	@XmlElement(name = "num_orders")
	public int numberoforder;
	
	@XmlElement(name = "order_values")
	public float totalOrdervalue;
	
	
	/**
	 * Default Constructor
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param customerName
	 * @param address
	 * @param numberoforder
	 * @param totalOrdervalue
	 */
	public Customer(String customerName, Address address,
			int numberoforder, float totalOrdervalue) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.numberoforder = numberoforder;
		this.totalOrdervalue = totalOrdervalue;
	}




	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}


	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}


	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	/**
	 * @return the salesRepEmployeeNumber
	 */
	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}


	/**
	 * @param salesRepEmployeeNumber the salesRepEmployeeNumber to set
	 */
	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}


	/**
	 * @return the numberoforder
	 */
	public int getNumberoforder() {
		return numberoforder;
	}


	/**
	 * @param numberoforder the numberoforder to set
	 */
	public void setNumberoforder(int numberoforder) {
		this.numberoforder = numberoforder;
	}


	/**
	 * @return the totalOrdervalue
	 */
	public float getTotalOrdervalue() {
		return totalOrdervalue;
	}


	/**
	 * @param totalOrdervalue the totalOrdervalue to set
	 */
	public void setTotalOrdervalue(float totalOrdervalue) {
		this.totalOrdervalue = totalOrdervalue;
	}
	

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName
				+ ", salesRepEmployeeNumber=" + salesRepEmployeeNumber + ", numberoforder=" + numberoforder
				+ ", totalOrdervalue=" + totalOrdervalue + "]";
	}


	

	
	
	

}
