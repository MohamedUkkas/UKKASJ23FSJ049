package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public abstract class DiseaseControlManagerImpl implements DiseaseControlManager {
	
	private Disease[] diseases;
	private Patient[] patients;
	
	public DiseaseControlManagerImpl(int maxDiseases, int  maxPatients) {
		super();
		
		if(maxDiseases<=0) {
			throw new IllegalArgumentException("Invalid amount of diseases");
		}else if(maxPatients<=0) {
			throw new IllegalArgumentException("Invalid amount of patients");
		}
		
		this.diseases = new Disease[maxDiseases];
		this.patients = new Patient[maxPatients];
	}
	@Override
	public Disease addDisease(String Name, boolean infectious) {
		// TODO Auto-generated method stub
		int elementsPresent=checkDiseaseElements(this.diseases);
		if (elementsPresent==this.diseases.length) {
			throw new IndexOutOfBoundsException();
		}
			for(int i=elementsPresent-1;i<this.diseases.length;) {
				if (infectious) {
					this.diseases[i]=new InfectiousDisease();
				this.diseases[i].setName(Name);
				}
				else {
					this.diseases[i]=new NonInfectiousDisease();
					this.diseases[i].setName(Name);
				}
				return null;

			}
		return null;
	}
/**
 * Check the already available diseases in the diseases array
 * @param diseases2
 * @return Returns the number of diseases record currently present
 */
	private int checkDiseaseElements(Disease[] diseases2) {
		int elements=1;
		for(int i=1;i<diseases2.length;i++) {
			if(diseases2[i]!=null) {
				elements++;
			}
		}
		return elements;
	}
	@Override
	public Disease getDisease(UUID diseaseId) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.diseases.length;i++) {
			if(diseaseId==this.diseases[i].getDiseaseId())
				return this.diseases[i];
		}
		
		return null;
	}
	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		int elementsPresent=checkPatientsElements(this.patients);
		if (elementsPresent==this.patients.length) {
			throw new IndexOutOfBoundsException();
		}
			for(int i=elementsPresent-1;i<this.patients.length;) {
				this.patients[i]=new Patient(maxDiseases, maxExposures);
				this.patients[i].setPatientId(UUID.randomUUID());
				this.patients[i].setFirstName(firstName);
				this.patients[i].setLastName(lastName);
				return null;

			}		
			return null;
	}
	/**
	 * Check the already available Patients in the patients array
	 * @param patients2
	 * @return Returns the number of patients record currently present
	 */
	
	private int checkPatientsElements(Patient[] patients2) {
		int elements=1;
		for(int i=1;i<patients.length;i++) {
			if(patients2[i]!=null) {
				elements++;
			}
		}
		return elements;
	}
	@Override
	public Patient getPatient(UUID patientId) {
		for(int i=0;i<this.patients.length;i++) {
			if(patientId==this.patients[i].getPatientId())
				return this.patients[i];
		}
		
		return null;
	}
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID DiseaseId) {
		UUID validDiseaseId=checkValid(DiseaseId);
		
		
		for(int i=0;i<this.patients.length;i++) {
			if(patientId==this.patients[i].getPatientId()) {
				this.patients[i].addDiseaseId(validDiseaseId);
				return;
			}
		}
		throw new IllegalArgumentException();
	}
	/**
	 * check whether the DIsease Id provided is valid or not
	 * @param diseaseId
	 * @return Returns the Valid Id if not throws an IllegalArgumentException
	 */
	private UUID checkValid(UUID diseaseId) {
		for(int i=0;i<this.diseases.length;i++) {
			if(diseaseId==this.diseases[i].getDiseaseId()) {
				return this.diseases[i].getDiseaseId();
			}
		}throw new IllegalArgumentException();
		
	}
	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		

		for(int i=0;i<this.patients.length;i++) {
			if(patientId==this.patients[i].getPatientId()) {
				this.patients[i].addExposure(exposure);;
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	
}
