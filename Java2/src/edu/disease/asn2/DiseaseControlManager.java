package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public interface DiseaseControlManager {
	/**
	 * The method to add disease into an diseases array
	 * @param Name
	 * @param infectious
	 * @return
	 */
	Disease addDisease(String Name, boolean infectious);
	/**
	 * The method to fetch disease using Id as parameter
	 * @param diseaseId
	 * @return
	 */
	Disease getDisease(UUID diseaseId);
	/**
	 * Method to create Patient instance record
	 * @param firstName
	 * @param lastName
	 * @param maxDiseases
	 * @param maxExposures
	 * @return
	 */
	Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures);
	/**
	 * The method to fetch Patient using Patient ID from patients array list
	 * @param patientId
	 * @return
	 */
	Patient getPatient(UUID patientId);
	
	/**
	 * The method to merge disease record with patient 
	 * @param patientId
	 * @param DiseaseId
	 */
	void addDiseaseToPatient(UUID patientId,UUID DiseaseId);
	
	/**
	 * The method to merge Exposure record with patient
	 * @param patientId
	 * @param exposure
	 */
	void addExposureToPatient(UUID patientId, Exposure exposure);
	
	
}