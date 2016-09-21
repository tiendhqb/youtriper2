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
public class ResourcesDTO {
    private int resourceID;
    private int providerID;
    private String name;
    private int noPeople;
    private String note;

    public ResourcesDTO() {
    }

    public ResourcesDTO(int resourceID, String name, int noPeople) {
        this.resourceID = resourceID;
        this.name = name;
        this.noPeople = noPeople;
    }

    public ResourcesDTO(int resourceID, int providerID, String name, int noPeople, String note) {
        this.resourceID = resourceID;
        this.providerID = providerID;
        this.name = name;
        this.noPeople = noPeople;
        this.note = note;
    }

    public ResourcesDTO(int resourceID, String name, int noPeople, String note) {
        this.resourceID = resourceID;
        this.name = name;
        this.noPeople = noPeople;
        this.note = note;
    }

    
    
    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoPeople() {
        return noPeople;
    }

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }
    
    
}
