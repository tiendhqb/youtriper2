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
public class ServingPeriodDTO {
    private int id;
    private int providerID;
    private String startOperationTime;
    private String endOperationTime;
    private String name;

    public ServingPeriodDTO() {
    }

    public ServingPeriodDTO(int id, int providerID, String startOperationTime, String endOperationTime, String name) {
        this.id = id;
        this.providerID = providerID;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.name = name;
    }

    public ServingPeriodDTO(int id, String startOperationTime, String endOperationTime, String name) {
        this.id = id;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getStartOperationTime() {
        return startOperationTime;
    }

    public void setStartOperationTime(String startOperationTime) {
        this.startOperationTime = startOperationTime;
    }

    public String getEndOperationTime() {
        return endOperationTime;
    }

    public void setEndOperationTime(String endOperationTime) {
        this.endOperationTime = endOperationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    
}
