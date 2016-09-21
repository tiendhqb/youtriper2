/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nick
 */
public class TripTypeDTO {
    private int tripTypeID;
    private String name;

    public TripTypeDTO() {
    }

    public TripTypeDTO(int tripTypeID, String name) {
        this.tripTypeID = tripTypeID;
        this.name = name;
    }

    public int getTripTypeID() {
        return tripTypeID;
    }

    public void setTripTypeID(int tripTypeID) {
        this.tripTypeID = tripTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
