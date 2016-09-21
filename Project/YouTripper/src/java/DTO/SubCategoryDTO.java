/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Nick
 */
public class SubCategoryDTO {
    private int subCategoryID;
    private String name;
    private int categoryID;
    private List<ActivityDTO> activites;
    private boolean selected; // advanced variable for creation and edition
    private String content;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(int subCategoryID, String name, int categoryID) {
        this.subCategoryID = subCategoryID;
        this.name = name;
        this.categoryID = categoryID;
    }
        public SubCategoryDTO(int subCategoryID, String name, int categoryID, String content) {
        this.subCategoryID = subCategoryID;
        this.name = name;
        this.categoryID = categoryID;
        this.content= content;
    }

    public SubCategoryDTO(int subCategoryID, String name, int categoryID, List<ActivityDTO> activites, boolean selected) {
        this.subCategoryID = subCategoryID;
        this.name = name;
        this.categoryID = categoryID;
        this.activites = activites;
        this.selected = selected;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public List<ActivityDTO> getActivites() {
        return activites;
    }

    public void setActivites(List<ActivityDTO> activites) {
        this.activites = activites;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
   
    
}
