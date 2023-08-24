package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;

/**
 * An Abstract class for Disease which used to inherit for Infectious and Non-Infectious diseases.
 */
abstract public class Disease {

	private UUID diseaseId;
	private String name;
	
	public UUID getDiseaseId() {
		return diseaseId;
	}
	
	
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
	}
	
	
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
	
	
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}
	/**
	 * Creating Abstract method
	 * @return This will return the results based on the behaviour, which we can used to achieve Polimorphism
	 */
	abstract String[] getExamples();
	
}
/**
 * Infectious Diseaseclass extends Disease so that all the properties of DIsease class wil be shared with Infectious diseases
 */
class InfectiousDisease extends Disease{
	
	/**
	 * Overriding the getExamples method to support separate child class
	 */
	@Override
	String[] getExamples() {
		// TODO Auto-generated method stub
		String[] examples= {"Common cold","Stomach Flu","COVID-19","Hepatitis"};
		
		return examples;
	}
	
}
/**
 * Non-Infectious Diseaseclass extends Disease so that all the properties of DIsease class wil be shared with Infectious diseases
 */
class NonInfectiousDisease extends Disease {
	/**
	 * Overriding the getExamples method to support separate child class
	 */
	@Override
	String[] getExamples() {
		// TODO Auto-generated method stub
		String[] examples= {"Diabetes","Injuries","Cancer","Respiratory Disease"};
		
		return examples;
	}
	
}
