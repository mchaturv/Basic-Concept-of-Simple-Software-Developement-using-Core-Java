import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mayank
 * @DaoClass Provides Method to fetch
 *	1. Customer List
 *	2. Product List
 *	3. Staff List
 */
public class SummaryDao {

	/**
	 * Declaring Connection object
	 */
	Connection connect;
	
	
	/**
	 * Default Constructor -  Establishing the Connection through JDBCConnector Class object
	 */
	public SummaryDao() throws UserDefinedSQLException {
		// TODO Auto-generated constructor stub
		JDBCConnector connector = new JDBCConnector();
		connect = connector.connect();
	}
	
	/**
	 * findCustomer -  Fetches the customer list who have placed orders between startDate and endDate
	 * @startDate -  Date startDate
	 * @endDate - Date endDate
	 */
	public ArrayList<Customer> findCustomers(Date startDate, Date endDate) throws UserDefinedSQLException {
		ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();

		// Converting java Date into Sql Date
		java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
		java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());

		// check if connection is not null
		if (connect != null) {
			Statement statement = null;
			try {
				statement = connect.createStatement();
				ResultSet resultSet = null;

				// Executing the Query to fetch the details into resultSet
				resultSet = statement.executeQuery(
						" SELECT  c.customerName, c.addressLine1, c.addressLine2, c.city, c.postalCode, c.country, \r\n"
								+ " sum(od.priceEach*od.quantityOrdered) as ordervalue, count(distinct(o.orderNumber)) as numberoforder \r\n"
								+ " FROM csci3901.orderdetails as od \r\n"
								+ " Inner join csci3901.orders as o on od.orderNumber = o.orderNumber\r\n"
								+ " INNER JOIN csci3901.customers as c where c.customerNumber = o.customerNumber\r\n"
								+ " and o.status <> 'Cancelled'"
								+ " and o.orderDate between '" + startDateSQL + "' and '" + endDateSQL + "'\r\n"
								+ " group by o.customerNumber;");

				// Retrieving each rows through ResultSet
				while (resultSet.next()) {

					// Defining New customer for existing row
					Customer customer = new Customer();
					customer.setCustomerName(resultSet.getString(1));
					Address address = new Address();
					address.setStreetAddress(resultSet.getString(2));
					address.setCity(resultSet.getString(4));
					address.setPostalCode(resultSet.getString(5));
					address.setCountry(resultSet.getString(6));
					customer.setAddress(address);
					customer.setTotalOrdervalue(resultSet.getFloat(7));
					customer.setNumberoforder(resultSet.getInt(8));

					// Adding customer to customer list
					listOfCustomers.add(customer);
				}
				
			} catch (SQLException e) {
				// Throwing User Defined SQL Exception with error message
				throw new UserDefinedSQLException(
						"SQL Connection Error : Please try reconnecting again.\n" + e.getMessage());
			}

		}
		// returning the customer list
		return listOfCustomers;
	}
	
	
	/**
	 * findProduct -  Fetches the product list with unit sold and total sale for each product ordered between startDate and endDate
	 * @startDate -  Date startDate
	 * @endDate - Date endDate
	 */
	public ArrayList<ProductSet> findProducts(Date startDate, Date endDate) throws UserDefinedSQLException {
		ArrayList<ProductSet> listOfProducts = new ArrayList<ProductSet>();

		// Converting java Date into Sql Date
		java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
		java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());

		// check if connection is not null
		if (connect != null) {
			Statement statement = null;
			try {
				statement = connect.createStatement();
				statement.execute("use csci3901");
				ResultSet resultSet = null;

				// Executing the Query to fetch the details into resultSet
				resultSet = statement.executeQuery(" SELECT p.productName, p.productLine, p.productVendor,\r\n"
						+ " sum(od.priceEach*od.quantityOrdered) as totolValue, sum(od.quantityOrdered) as totalQuantity\r\n"
						+ " FROM orderdetails as od \r\n"
						+ " INNER JOIN products as p on p.productCode=od.productCode \r\n"
						+ " INNER JOIN orders as o where od.orderNumber = o.orderNumber \r\n"
						+ " and o.status <> 'Cancelled'"
						+ " and o.orderDate between '" + startDateSQL + "' and '" + endDateSQL + "' \r\n"
						+ " group by p.productCode;");

				// Retrieving each rows through ResultSet
				while (resultSet.next()) {

					String productLineName = resultSet.getString(2);
					// Defining new ProductSet.
					ProductSet productSet = new ProductSet();
					productSet.setProductList(new ArrayList<Product>());
					productSet.setProductLineName(productLineName);

					boolean exists = false;
					// Iterating through productList to fetch productSets.
					for (ProductSet existingProdSet : listOfProducts) {
						// Check if any productSet is existing with same productLineName.
						if (existingProdSet.equals(productSet)) {
							// If Existing, Assign the newly ProductSet with the Existing one.
							productSet = existingProdSet;
							exists = true;
							break;
						}
					}

					// Define the new Product detail fetch in current row and assign details to the product.
					Product product = new Product(resultSet.getString(1), resultSet.getString(3), resultSet.getInt(5),
							resultSet.getFloat(4));

					// Set the product into ProductSet.
					productSet.getProductList().add(product);

					// if a new productSet is Created with new Product Line Name add the product Set into the product List.
					if (!exists) {
						listOfProducts.add(productSet);
					}
				}

			} catch (SQLException e) {
				// Throwing User Defined SQL Exception with error message
				throw new UserDefinedSQLException(
						"SQL Connection Error : Please try reconnecting again.\n" + e.getMessage());
			}

		}
		// returning list of products fetched
		return listOfProducts;

	}
	
	
	/**
	 * findStaffList -  Fetches the staff list with unit sold and total sale for each staff who have orders between startDate and endDate
	 * @startDate -  Date startDate
	 * @endDate - Date endDate
	 */
	public ArrayList<Employee> findStaffList(Date startDate, Date endDate) throws UserDefinedSQLException {
		ArrayList<Employee> employeelist = new ArrayList<Employee>();

		// Converting java Date into Sql Date
		java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
		java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());

		// check if connection is not null
		if (connect != null) {
			Statement statement = null;
			try {
				statement = connect.createStatement();
				statement.execute("use csci3901");
				ResultSet resultSet = null;

				// Executing the Query to fetch the details into resultSet
				resultSet = statement.executeQuery(
						" SELECT e.firstName, e.lastName, ofc.city, count(distinct(c.customerNumber)), sum(od.quantityOrdered*od.priceEach) FROM employees as e\r\n"
								+ " INNER JOIN offices as ofc on ofc.officeCode = e.officeCode \r\n"
								+ " INNER JOIN customers as c on c.salesRepEmployeeNumber = e.employeeNumber\r\n"
								+ " INNER JOIN orders as o on c.customerNumber = o.customerNumber\r\n"
								+ " INNER JOIN orderdetails od on od.orderNumber = o.orderNumber\r\n"
								+ " where o.orderDate between '" + startDateSQL + "' and '" + endDateSQL + "'\r\n"
								+ " and o.status <> 'Cancelled'"
								+ " group by e.employeeNumber;");

				// Retrieving each rows through ResultSet
				while (resultSet.next()) {

					// Defining new Employee for the current row fetched
					Employee employee = new Employee(resultSet.getString(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getInt(4), resultSet.getFloat(5));

					// Adding Employee into employee list
					employeelist.add(employee);
				}

			} catch (SQLException e) {
				// Throwing User Defined SQL Exception with error message
				throw new UserDefinedSQLException(
						"SQL Connection Error : Please try reconnecting again.\n" + e.getMessage());
			}

		}

		// returning the employee list
		return employeelist;

	}
	
	/**
	 * Closing the Database Connection
	 */
	public void close() throws UserDefinedSQLException {
		try {
			// closing the active connection
			connect.close();
		} catch (SQLException e) {
			// Throwing User Defined SQL Exception with error message
			throw new UserDefinedSQLException("SQL Connection Error : Not able to close the connection - Try again");
		}
	}
	
	
	

}
