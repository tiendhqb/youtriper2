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
public class ProviderSignupForm {
    private List<CountryDTO> countries;
    private List<BusinessTypeDTO> businesses;
    private List<CityDTO> cities;

    public ProviderSignupForm() {
    }

    public ProviderSignupForm(List<CountryDTO> countries, List<BusinessTypeDTO> businesses) {
        this.countries = countries;
        this.businesses = businesses;
    }

    public ProviderSignupForm(List<CountryDTO> countries, List<BusinessTypeDTO> businesses, List<CityDTO> cities) {
        this.countries = countries;
        this.businesses = businesses;
        this.cities = cities;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }

    public List<BusinessTypeDTO> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<BusinessTypeDTO> businesses) {
        this.businesses = businesses;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }
}
