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
public class TargetCountryDTO {
    private int targetCountryID;
    private String name;

    public TargetCountryDTO(int targetCountryID, String name) {
        this.targetCountryID = targetCountryID;
        this.name = name;
    }
   
    public int getTargetCountryID() {
        return targetCountryID;
    }

    public void setTargetCountryID(int targetCountryID) {
        this.targetCountryID = targetCountryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
