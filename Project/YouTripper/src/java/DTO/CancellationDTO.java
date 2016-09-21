/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class CancellationDTO {

    private int cancellationID;
    private int providerID;
    private String name;
    private String condition;

    public CancellationDTO(int cancellationID, int providerID, String name, String condition) {
        this.cancellationID = cancellationID;
        this.providerID = providerID;
        this.name = name;
        this.condition = condition;
    }

    public int getCancellationID() {
        return cancellationID;
    }

    public void setCancellationID(int cancellationID) {
        this.cancellationID = cancellationID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
