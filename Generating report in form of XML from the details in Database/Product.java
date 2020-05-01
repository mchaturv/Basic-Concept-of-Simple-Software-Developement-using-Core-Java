


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mayank
 * @Bean Class defined for Product
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {


	@XmlElement(name = "product_name")
	public String productName; 
	@XmlElement(name = "product_vendor")
	public String productVendor;
	@XmlElement(name = "units_sold")
	public int unitSold;
	@XmlElement(name = "total_sales")
	public float totalSale;

	/**
	 * Default Constructor
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param productName
	 * @param productVendor
	 * @param unitSold
	 * @param totalSale
	 */
	public Product(String productName, String productVendor, int unitSold, float totalSale) {
		super();
		this.productName = productName;
		this.productVendor = productVendor;
		this.unitSold = unitSold;
		this.totalSale = totalSale;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}



	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return productVendor;
	}

	/**
	 * @param productVendor the productVendor to set
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	

	/**
	 * @return the unitSold
	 */
	public int getUnitSold() {
		return unitSold;
	}

	/**
	 * @param unitSold the unitSold to set
	 */
	public void setUnitSold(int unitSold) {
		this.unitSold = unitSold;
	}

	/**
	 * @return the totalSale
	 */
	public float getTotalSale() {
		return totalSale;
	}

	/**
	 * @param totalSale the totalSale to set
	 */
	public void setTotalSale(float totalSale) {
		this.totalSale = totalSale;
	}


	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productVendor=" + productVendor + ", unitSold=" + unitSold
				+ ", totalSale=" + totalSale + "]";
	}	

}
