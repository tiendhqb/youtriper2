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
public class PopularPackageDTO {

    private int packageID;
    private String name;
//    private int numberRates;

    public PopularPackageDTO() {
    }

    public PopularPackageDTO(int packageID, String name) {
        this.packageID = packageID;
        this.name = name;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
