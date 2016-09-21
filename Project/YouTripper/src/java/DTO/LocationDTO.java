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
public class LocationDTO {

    private String Country;
    private String City;
    private String State;

    public LocationDTO() {
    }

    public LocationDTO(String Country, String City, String State) {
        this.Country = Country;
        this.City = City;
        this.State = State;
    }

    public LocationDTO(String Country, String City) {
        this.Country = Country;
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

}
