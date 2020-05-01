import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * @author Mayank
 * Class providing 
 * 1. @main method : Accept the input (StartDate, End Date and Output file name) from the user
 *                   Calls Service class method to retrieve details
 *
 */
public class Driver {

	/**
	 * @filename : String variable
	 * @summary : YearEndSummary Object
	 */
	private static String fileName ;
	private static YearEndSummary summary;
	
	/**
	 * Main Driver Method : Entry Point
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SummaryService service = new SummaryService();
		Date startDate = null, endDate = null;

		// Prompt user to provide input for Start Date
		System.out.println("Please provide the Start Date in YYYY-MM-DD");
		while (startDate == null) {
			
			// Accepting Input for Start Date
			String startDateString = sc.next();

			// Validate if provided Date is valid or not
			startDate = verifyInput(startDateString);

			// If Input date provided is not valid
			if (startDate == null) {
				System.err.println("Invalid Start Date Provided.\n");
				System.out.flush();
				System.out.println("Please provide correct start Date in valid Format : YYYY-MM-DD");
			}
		}

		// Prompt user to provide input for End Date
		System.out.println("\nPlease provide the End Date in YYYY-MM-DD");
		while (endDate == null) {
			
			// Accepting Input for Start Date
			String endDateString = sc.next();

			// Validate if provided Date is valid or not
			endDate = verifyInput(endDateString);

			// If Input date provided is not valid
			if (endDate == null) {
				System.err.println("Invalid End Date Provided.\n");
				System.out.flush();
				System.out.println("Please provide correct end Date in valid Format : YYYY-MM-DD");
			}
		}

		// Prompt user to provide input for File Name
		System.out.println("\nPlease provide the output File Name (Without Extension(i.e. '.xml'))");
		Boolean validFile =false;
		while (fileName == null || fileName.isEmpty()||!validFile) {
			fileName = sc.next().trim();
			if (!fileName.matches("([^\\.])([\\w]*)([\\W\\.\\w]*)")) {
				System.out.println("\nInvalid FileName. Please provide valid File Name(Without Extension(i.e '.xml') again:");
			}
			else {
				validFile = true;
				break;
			}
		}

		// Close Scanner
		sc.close();

		try {
			
			// Create a JAXBContext Instance for "YearEndSummary" Class
			JAXBContext context = JAXBContext.newInstance(YearEndSummary.class);

			// Marshal the context
			Marshaller m = context.createMarshaller();

			// print XML in JAXB refering the yearEndSummary class
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Calling the Service Class to get the year end summary details and assigning it to YearEndSummary object
			summary = service.getSummary(startDate, endDate);

			// Write the details to File

			m.marshal(summary, new File("./"+fileName + ".xml"));
			System.out.println("\nData Successfully Written into "+fileName+".xml file");
			
		} catch (JAXBException e) {
			System.err.println("Unable to format the Data into XML.");
		} catch (UserDefinedSQLException e) {
			// Handling User Defined SQL Exception and print the error message
			System.err.println(e.getMessage());
		}

	}
	
	/**
	 * @method : to verify user provided date input is in valid format or not
	 */
	public static Date verifyInput(String input) {
		  if (input != null) {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    try {
		      java.util.Date ret = sdf.parse(input.trim());
		      
		      if (sdf.format(ret).equals(input.trim())) {
		    	// return date object if input was valid date
		        return ret;
		      }
		    } catch (ParseException e) {
		    }
		  }
		  // return null if not valid 
		  return null;
		}

}
