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
public class FilterOption {

    private List<String> keywords;
    private List<LocationDTO> locations;
    private List<PopularPackageDTO> popularPackages;

    public FilterOption() {
    }

    public FilterOption(List<String> keywords, List<LocationDTO> locations, List<PopularPackageDTO> popularPackages) {
        this.keywords = keywords;
        this.locations = locations;
        this.popularPackages = popularPackages;
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

}
