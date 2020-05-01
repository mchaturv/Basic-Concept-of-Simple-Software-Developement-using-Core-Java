


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Mayank
 * @ServiceClass : Define Method to call summeryDao method and fetch details separately 
 * and consolidate all the details into single Year end summary object
 */
public class SummaryService {

	/**
	 * Declaring SummaryDao object
	 */ 
	private SummaryDao fetchCustomer;

	
	/**
	 * Default Constructor
	 */ 
	public SummaryService() {
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * @method : Calls findCustomers, findProducts and findStaffList method of summaryDao to fetch details.
	 */ 
	public YearEndSummary getSummary(Date startDate, Date endDate) throws UserDefinedSQLException {
		
		// Defining year end summary object
		YearEndSummary summary = new YearEndSummary();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = formatter.format(startDate);
		String endDateString = formatter.format(endDate);

		Year year = new Year(startDateString, endDateString);
		// set the year into year end summary
		summary.setYear(year);

		ArrayList<Customer> listOfCustomer = new ArrayList<Customer>();
		ArrayList<ProductSet> listOfproducts = new ArrayList<ProductSet>();
		ArrayList<Employee> listOfstaffs = new ArrayList<Employee>();

		fetchCustomer = new SummaryDao();

		// Calls findCustomers, findProducts and findStaffList method
		listOfCustomer = fetchCustomer.findCustomers(startDate, endDate);
		listOfproducts = fetchCustomer.findProducts(startDate, endDate);
		listOfstaffs = fetchCustomer.findStaffList(startDate, endDate);

		// Set the customer list,product list and staff list into the year end summary
		summary.setCustomerList(listOfCustomer);
		summary.setProductSet(listOfproducts);
		summary.setStaffList(listOfstaffs);

		// return the year end summary object
		return summary;

	}
	

	
	

}
