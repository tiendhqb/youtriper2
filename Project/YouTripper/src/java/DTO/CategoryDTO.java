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
public class CategoryDTO {

    private int id;
    private String name;
    private String image;
    private String icon;

    public CategoryDTO(int id, String name, String image, String icon) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }
    
    public CategoryDTO(int id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
    
    public CategoryDTO(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
    
    
}
