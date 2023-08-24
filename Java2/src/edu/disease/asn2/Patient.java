package edu.disease.asn2;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn1.Exposure;

public class Patient implements Comparable<Patient> {


	
	
	private UUID patientId;
	private String firstName;
	private String lastName;
	public Exposure[] exposures;
	public UUID[] diseaseIds;
	
	
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
		return Objects.hash(patientId);
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
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}
	
	

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
	}
	/**
	 * Here I'm using Arrays.sort() method to sort the array in ascending order with respect to last name then first name
	 * so I need to override the comparator method and to implement the Comparable Interface to it
	 */
	@Override
    public int compareTo(Patient other) {
        int lastNameComparison = lastName.compareTo(other.lastName);
        
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        
        return firstName.compareTo(other.firstName);
    }
/**
 * This will construct a Patient object with amount of disease and exposure details,
 * which will be further used to add disease and exposure details.
 * @param maxDiseases- How many Disease can this patient accomodate
 * @param maxExposures- How many Exposure can this patient accomodate
 */
	public Patient( int maxDiseases, int maxExposures) {
		if(maxExposures<=0)
			throw new IllegalArgumentException("Atleast 1 Disease and 1 Exposure must be declared");
		else if(maxDiseases<=0)
			throw new IllegalArgumentException("Atleast 1 Disease and 1 Exposure must be declared");
		else {
		this.exposures = new Exposure[maxExposures];
		this.diseaseIds = new UUID[maxDiseases];
		}
	}
	
	/**
	 * This method is used to push the disease Id for the reported diseases on object creation
	 * and will throws IndexOutOfBoundsException when disease IDs exceeds the disease count
	 * @param diseaseId
	 */
	public void addDiseaseId(UUID diseaseId) {
		
		int elementsPresent = checkDiseaseElements(this.diseaseIds);

	    // Check if there's space to add the diseaseId
	    if (elementsPresent >= this.diseaseIds.length) {
	        throw new IndexOutOfBoundsException("Disease list items exceeded");
	    }

	    // Find the first available slot and add the diseaseId
	    for (int i = 0; i < this.diseaseIds.length; i++) {
	        if (this.diseaseIds[i] == null) {
	            this.diseaseIds[i] = diseaseId;
	            return; // Exit the loop once the diseaseId is added
	        }
	    }
	}

	/**
	 * This is the custom method to check how many valid elements available as of now on diseaseIds array
	 * So, that we can add or throws error while addDiseaseIds method called
	 * @param diseaseIds2
	 * @return The count of valid elements present at Disease Ids array.
	 */
	private int checkDiseaseElements(UUID[] diseaseIds2) {
		// TODO Auto-generated method stub
		int elements=1;
		for(int i=1;i<diseaseIds2.length;i++) {
			if(diseaseIds2[i]!=null) {
				elements++;
			}
		}
		return elements;
	}
	
	/**
	 * This method is used to push the Exposures for the reported exposure on object creation
	 * and will throws IndexOutOfBoundsException when exposure exceeds the exposures count
	 * @param exposure
	 */
	public void addExposure(Exposure exposure) {
		int elementsPresent=checkExposureElements(this.exposures);
		if (elementsPresent==this.exposures.length) {
			throw new IndexOutOfBoundsException();
		}
			for(int i=0;i<this.getExposures().length;) {
			
				this.exposures[i]=exposure;
				return;

			}
		
	}

	/**
	 * This is the custom method to check how many valid elements available as of now on Exposures array
	 * So, that we can add or throws error while addExposure method called
	 * @param exposure2
	 * @return The count of valid elements present at Exposures array.
	 */
	private int checkExposureElements(Exposure[] exposure2) {
		// TODO Auto-generated method stub
		int elements=1;
		for(int i=1;i<exposure2.length;i++) {
			if(exposure2[i]!=null) {
				elements++;
			}
		}
		return elements;
	}
	
	

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Exposure[] getExposures() {
		return exposures;
	}

	public void setExposures(Exposure[] exposures) {
		this.exposures = exposures;
	}


	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds;
	}
	
	
	

}


