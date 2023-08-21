package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;


/**
 * This will create an instance of Disease data for Patient
 * @author MohamedUkkas
 * @version 1.0
 */
public class Disease {

	private UUID diseaseId;
	private String name;
	
	/**
	 * 
	 * @return Returns the UUID of Disease
	 */
	public UUID getDiseaseId() {
		return diseaseId;
	}
	
	/**
	 * This method will set UUID value for Disease.
	 * @param diseaseId
	 */
	public void setDiseaseId() {
		this.diseaseId = UUID.randomUUID();
	}
	
	/**
	 * 
	 * @return Returns the Disease name declared
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method will set name for the Disease.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 	The hashCode() method should return the same integer value for the same object
	 *  for each calling of this method unless the value stored in the object is modified. 
	 *  If two objects are equal(according to equals() method) then the hashCode() method should 
	 *  return the same integer value for both the objects.
	 *  
	 *  In HashMap, hashCode() is used to calculate the bucket and therefore calculate the index. 
	 *  
	 */
	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
	}
	
	/**
	 * equals() method: This method is used to check whether 2 objects are equal or not. 
	 * This method is provided by the Object class
	 * 
	 * If two objects are equal according to the equals(Object) method, 
	 * then calling the hashCode method on each of the two objects must produce the same integer result.
	 * It is not required that if two objects are unequal according to the equals(java.lang.Object) method,
	 *  then calling the hashCode method on each of the two objects must produce distinct integer results. 
	 *  However, the programmer should be aware that producing distinct integer results 
	 *  for unequal objects may improve the performance of hashtables.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}
	
	
	
}