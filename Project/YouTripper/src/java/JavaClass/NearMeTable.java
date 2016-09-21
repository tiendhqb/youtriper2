/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import java.util.List;

/**
 *
 * @author Nick
 */
public class NearMeTable {
    private List<NearMeCategory> categories;
    private List<NearMeLocation> locations;
    public static String nearMeJson = "";

    public NearMeTable(List<NearMeCategory> categories, List<NearMeLocation> locations) {
        this.categories = categories;
        this.locations = locations;
    }

    public List<NearMeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<NearMeCategory> categories) {
        this.categories = categories;
    }

    public List<NearMeLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<NearMeLocation> locations) {
        this.locations = locations;
    }
    
}
