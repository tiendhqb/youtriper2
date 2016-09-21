/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Long Nguyen
 */
public class BusinessResourceDTO {

    private int businessResourceID;
    private String resourceName;
    private int capacity;
    private int noSkills;
    private int skillID;

    public BusinessResourceDTO() {
    }

    public BusinessResourceDTO(int businessResourceID, String resourceName, int capacity, int noSkills, int skillID) {
        this.businessResourceID = businessResourceID;
        this.resourceName = resourceName;
        this.capacity = capacity;
        this.noSkills = noSkills;
        this.skillID = skillID;
    }

    public int getBusinessResourceID() {
        return businessResourceID;
    }

    public void setBusinessResourceID(int businessResourceID) {
        this.businessResourceID = businessResourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNoSkills() {
        return noSkills;
    }

    public void setNoSkills(int noSkills) {
        this.noSkills = noSkills;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

}
