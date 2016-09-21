/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nick
 */
public class AdvancedSearchForm {
    private List<PackagesViewDTO> packages;
    private List<String> keywords;
    private List<LocationDTO> locations;
    private List<PopularPackageDTO> popularPackages;
    private HashMap<String,PackagesViewDTO> suggestion;

    public AdvancedSearchForm() {
    }

    public AdvancedSearchForm(List<String> keywords, List<LocationDTO> locations, List<PopularPackageDTO> popularPackages) {
        this.keywords = keywords;
        this.locations = locations;
        this.popularPackages = popularPackages;
    }

    public AdvancedSearchForm(List<PackagesViewDTO> packages, List<String> keywords, List<LocationDTO> locations, List<PopularPackageDTO> popularPackages) {
        this.packages = packages;
        this.keywords = keywords;
        this.locations = locations;
        this.popularPackages = popularPackages;
    }
    
    

    public List<PackagesViewDTO> getPackages() {
        return packages;
    }

    public void setPackages(List<PackagesViewDTO> packages) {
        this.packages = packages;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDTO> locations) {
        this.locations = locations;
    }

    public List<PopularPackageDTO> getPopularPackages() {
        return popularPackages;
    }

    public void setPopularPackages(List<PopularPackageDTO> popularPackages) {
        this.popularPackages = popularPackages;
    }

    public HashMap<String, PackagesViewDTO> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(HashMap<String, PackagesViewDTO> suggestion) {
        this.suggestion = suggestion;
    }
    
}
