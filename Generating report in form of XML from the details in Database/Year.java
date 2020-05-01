
/**
 * 
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Mayank
 * @Bean class Defined for Year
 */

@XmlRootElement(name = "year")
@XmlAccessorType(XmlAccessType.FIELD)
public class Year {

	@XmlElement(name = "start_date")
	public String startDate;
	
	@XmlElement(name = "end_date")
	public String endDate;
	
	
	/**
	 * 
	 */
	public Year() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 */
	public Year(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	
	
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Year other = (Year) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Year [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
	
	

}
