/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import JavaClass.AdvancedCategory;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nick
 */
public class PackageForm {
    private List<CategoryDTO> categories;
    private List<SubCategoryDTO> subCategories;
    private List<ActivityDTO> activities;
    private List<AmenitiesDTO> listAmenities;
    private List<TransportationDTO> transportations;
    private List<GroupTypeDTO> groupTypes;
    private List<TripTypeDTO> tripTypes;
    private HashMap<Integer,AdvancedCategory> categoryRelation;
    private List<CertificateDTO> certificates;
    private List<LanguageDTO> languageList;
    private List<TargetCountryDTO> targetCountry;
    private List<PackageColorDTO> packageColor;
    private List<CancellationDTO> cancellations;
    private List<ChildrenDiscountDTO> childrenDiscounts;
    private List<DisabledDiscountDTO> disabledDiscounts;
    private List<ResourcesDTO> providerResources;
    private List<ServingPeriodDTO> servingPeriods;

    public PackageForm() {
    }

    public PackageForm(List<CategoryDTO> categories, List<SubCategoryDTO> subCategories, List<ActivityDTO> activities, List<AmenitiesDTO> listAmenities, List<TransportationDTO> transportations, List<GroupTypeDTO> groupTypes, List<TripTypeDTO> tripTypes) {
        this.categories = categories;
        this.subCategories = subCategories;
        this.activities = activities;
        this.listAmenities = listAmenities;
        this.transportations = transportations;
        this.groupTypes = groupTypes;
        this.tripTypes = tripTypes;
    }

    public PackageForm(List<CategoryDTO> categories, List<SubCategoryDTO> subCategories, List<ActivityDTO> activities,
            List<AmenitiesDTO> listAmenities, HashMap<Integer, AdvancedCategory> categoryRelation, List<CertificateDTO> certificates,
            List<LanguageDTO> languageList,List<TargetCountryDTO> targetCountry,List<PackageColorDTO> packageColor) {
        this.categories = categories;
        this.subCategories = subCategories;
        this.activities = activities;
        this.listAmenities = listAmenities;
        this.categoryRelation = categoryRelation;
        this.certificates = certificates;
        this.languageList = languageList;
        this.targetCountry = targetCountry;
        this.packageColor = packageColor;
    }
    
    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<SubCategoryDTO> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryDTO> subCategories) {
        this.subCategories = subCategories;
    }

    public List<ActivityDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDTO> activities) {
        this.activities = activities;
    }

    public List<AmenitiesDTO> getListAmenities() {
        return listAmenities;
    }

    public void setListAmenities(List<AmenitiesDTO> listAmenities) {
        this.listAmenities = listAmenities;
    }

    public List<TransportationDTO> getTransportations() {
        return transportations;
    }

    public void setTransportations(List<TransportationDTO> transportations) {
        this.transportations = transportations;
    }

    public List<GroupTypeDTO> getGroupTypes() {
        return groupTypes;
    }

    public void setGroupTypes(List<GroupTypeDTO> groupTypes) {
        this.groupTypes = groupTypes;
    }

    public List<TripTypeDTO> getTripTypes() {
        return tripTypes;
    }

    public void setTripTypes(List<TripTypeDTO> tripTypes) {
        this.tripTypes = tripTypes;
    }

    public HashMap<Integer, AdvancedCategory> getCategoryRelation() {
        return categoryRelation;
    }

    public void setCategoryRelation(HashMap<Integer, AdvancedCategory> categoryRelation) {
        this.categoryRelation = categoryRelation;
    }

    public List<CertificateDTO> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateDTO> certificates) {
        this.certificates = certificates;
    }

    public List<LanguageDTO> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDTO> languageList) {
        this.languageList = languageList;
    }

    public List<TargetCountryDTO> getTargetCountry() {
        return targetCountry;
    }

    public void setTargetCountry(List<TargetCountryDTO> targetCountry) {
        this.targetCountry = targetCountry;
    }

    public List<PackageColorDTO> getPackageColor() {
        return packageColor;
    }

    public void setPackageColor(List<PackageColorDTO> packageColor) {
        this.packageColor = packageColor;
    }

    public List<CancellationDTO> getCancellations() {
        return cancellations;
    }

    public void setCancellations(List<CancellationDTO> cancellations) {
        this.cancellations = cancellations;
    }

    public List<ChildrenDiscountDTO> getChildrenDiscounts() {
        return childrenDiscounts;
    }

    public void setChildrenDiscounts(List<ChildrenDiscountDTO> childrenDiscounts) {
        this.childrenDiscounts = childrenDiscounts;
    }

    public List<DisabledDiscountDTO> getDisabledDiscounts() {
        return disabledDiscounts;
    }

    public void setDisabledDiscounts(List<DisabledDiscountDTO> disabledDiscounts) {
        this.disabledDiscounts = disabledDiscounts;
    }

    public List<ResourcesDTO> getProviderResources() {
        return providerResources;
    }

    public void setProviderResources(List<ResourcesDTO> providerResources) {
        this.providerResources = providerResources;
    }

    public List<ServingPeriodDTO> getServingPeriods() {
        return servingPeriods;
    }

    public void setServingPeriods(List<ServingPeriodDTO> servingPeriods) {
        this.servingPeriods = servingPeriods;
    }
    
    
    
}
