import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;


/**
 * @author Mayank
 * @Bean class defined for the YearEndSummary
 */

@XmlRootElement(name = "year_end_summary")
@XmlAccessorType(XmlAccessType.FIELD)
public class YearEndSummary {

	@XmlElement(name = "year")
	private Year year;

	@XmlElementWrapper(name = "customer_list")
    @XmlElement(name = "customer")
	private ArrayList<Customer> customerList;
	
	@XmlElementWrapper(name = "product_list")
	@XmlElement(name = "product_set")
	private ArrayList<ProductSet> productSet;

	@XmlElementWrapper(name = "staff_list")
	@XmlElement(name = "employee")
	private ArrayList<Employee> staffList;
	

	/**
	 * 
	 */
	public YearEndSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param year
	 * @param customerList
	 * @param productSet
	 * @param staffList
	 */
	public YearEndSummary(Year year, ArrayList<Customer> customerList, ArrayList<ProductSet> productSet,
			ArrayList<Employee> staffList) {
		super();
		this.year = year;
		this.customerList = customerList;
		this.productSet = productSet;
		this.staffList = staffList;
	}



	/**
	 * @return the year
	 */
	public Year getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Year year) {
		this.year = year;
	}

	/**
	 * @return the customerList
	 */
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList the customerList to set
	 */
	
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	/**
	 * @return the productSet
	 */
	public ArrayList<ProductSet> getProductSet() {
		return productSet;
	}

	/**
	 * @param productSet the productSet to set
	 */
	public void setProductSet(ArrayList<ProductSet> productSet) {
		this.productSet = productSet;
	}

	/**
	 * @return the staffList
	 */
	public ArrayList<Employee> getStaffList() {
		return staffList;
	}

	/**
	 * @param staffList the staffList to set
	 */
	public void setStaffList(ArrayList<Employee> staffList) {
		this.staffList = staffList;
	}

	@Override
	public String toString() {
		return "YearEndSummary [year=" + year + ", customerList=" + customerList + ", productSet=" + productSet
				+ ", staffList=" + staffList + "]";
	}
	
	
	
	
	
	

}
