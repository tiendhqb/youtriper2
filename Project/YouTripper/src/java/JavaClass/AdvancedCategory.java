/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.SubCategoryDTO;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nick
 */
public class AdvancedCategory {

    private int categoryID;
    private String categoryName;
    private String categoryICon;
    private HashMap<Integer, SubCategoryDTO> subCategories;
    private boolean selected;

    public AdvancedCategory() {
    }

    public AdvancedCategory(int categoryID, String categoryName, String categoryICon, HashMap<Integer, SubCategoryDTO> subCategories, boolean selected) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryICon = categoryICon;
        this.subCategories = subCategories;
        this.selected = selected;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryICon() {
        return categoryICon;
    }

    public void setCategoryICon(String categoryICon) {
        this.categoryICon = categoryICon;
    }

    public void setSubCategories(HashMap<Integer, SubCategoryDTO> subCategories) {
        this.subCategories = subCategories;
    }

    public HashMap<Integer, SubCategoryDTO> getSubCategories() {
        return subCategories;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

}
