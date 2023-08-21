package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * This Exposure class will create an instance to capture
 * the exposure details for the Patient
 * 
 * @author MohamedUkkas
 * @version 1.0
 */
public class Exposure {
    private UUID patientId;
    private LocalDateTime dateTime;
    public String exposureType;

    /**
     * The hashCode() method should return the same integer value for the same object
     * for each calling of this method unless the value stored in the object is modified.
     * If two objects are equal(according to equals() method) then the hashCode() method should
     * return the same integer value for both the objects.
     * In HashMap, hashCode() is used to calculate the bucket and therefore calculate the index.
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateTime, patientId);
    }

    /**
     * equals() method: This method is used to check whether 2 objects are equal or not.
     * This method is provided by the Object class
     * If two objects are equal according to the equals(Object) method,
     * then calling the hashCode method on each of the two objects must produce the same integer result.
     * It is not required that if two objects are unequal according to the equals(java.lang.Object) method,
     * then calling the hashCode method on each of the two objects must produce distinct integer results.
     * However, the programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hashtables.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null)
            return false;
        else if (getClass() != obj.getClass())
            return false;
        Exposure other = (Exposure) obj;
        return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
    }

    /**
     * This will construct an Exposure with UUID
     */
    public Exposure(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getPatientId() {
        return this.patientId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getExposureType() {
        return exposureType;
    }

    public void setExposureType(String exposureType) {
        if (exposureType.equals("D") || exposureType.equals("I")) {
            this.exposureType = exposureType;
        } else {
            throw new IllegalArgumentException("Type should be either \"D\" for Direct Exposure or \"I\" for Indirect Exposure");
        }
    }
}