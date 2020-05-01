


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mayank
 * @Bean class defined for the ProductSet
 */

@XmlRootElement(name = "product_set")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSet {

	@XmlElement(name = "product_line_name")
	private String productLineName;
	
	@XmlElement(name = "product")
	private ArrayList<Product> productList;
	
	
	/**
	 * Default constructor
	 */
	public ProductSet() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param productLineName
	 * @param productList
	 */
	public ProductSet(String productLineName, ArrayList<Product> productList) {
		super();
		this.productLineName = productLineName;
		this.productList = productList;
	}



	/**
	 * @return the productLineName
	 */
	public String getProductLineName() {
		return productLineName;
	}


	/**
	 * @param productLineName the productLineName to set
	 */
	public void setProductLineName(String productLineName) {
		this.productLineName = productLineName;
	}


	/**
	 * @return the productList
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}


	/**
	 * @param productList the productList to set
	 */
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productLineName == null) ? 0 : productLineName.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		ProductSet other = (ProductSet) obj;
		if (productLineName == null) {
			if (other.productLineName != null)
				return false;
		} else if (!productLineName.equals(other.productLineName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductSet [productLineName=" + productLineName + ", productList=" + productList + "]";
	}
	
	

}
