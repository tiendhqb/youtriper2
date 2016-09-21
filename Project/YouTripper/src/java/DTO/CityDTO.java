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
public class CityDTO {

    private int cityID;
    private String name;
    private int code;
    private int countryID;

    public CityDTO() {
    }

    public CityDTO(int cityID, String name, int code, int countryID) {
        this.cityID = cityID;
        this.name = name;
        this.code = code;
        this.countryID = countryID;
    }

    public CityDTO(int cityID, String name, int countryID) {
        this.cityID = cityID;
        this.name = name;
        this.countryID = countryID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
    
    
}
