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
public class GroupTypeDTO {
    private int groupTypeID;
    private String name;

    public GroupTypeDTO() {
    }

    public GroupTypeDTO(int groupTypeID, String name) {
        this.groupTypeID = groupTypeID;
        this.name = name;
    }

    public int getGroupTypeID() {
        return groupTypeID;
    }

    public void setGroupTypeID(int groupTypeID) {
        this.groupTypeID = groupTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
