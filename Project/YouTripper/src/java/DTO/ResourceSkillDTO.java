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
public class ResourceSkillDTO {
    private int skillID;
    private String name;
    private int providerID;

    public ResourceSkillDTO() {
    }

    public ResourceSkillDTO(int skillID, String name, int providerID) {
        this.skillID = skillID;
        this.name = name;
        this.providerID = providerID;
    }

    public ResourceSkillDTO(int skillID, String name) {
        this.skillID = skillID;
        this.name = name;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }
    
    
    
}
