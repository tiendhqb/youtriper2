/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author Nick
 */
public class NearMeLocation {
    String location;
    int totalPackages;

    public NearMeLocation() {
    }

    public NearMeLocation(String location, int totalPackages) {
        this.location = location;
        this.totalPackages = totalPackages;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(int totalPackages) {
        this.totalPackages = totalPackages;
    }
    
}
