/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class ChildrenDiscountDTO {

    private int childrenDiscountID;
    private String condition;
    private int age;
    private String ageType;
    private int discountPercent;
    private boolean isFree;
    private int providerID;
    private int packageID;

    public ChildrenDiscountDTO(int packageID, int childrenDiscountID) {
        this.packageID = packageID;
        this.childrenDiscountID = childrenDiscountID;
    }

    public ChildrenDiscountDTO(int childrenDiscountID, String condition, int age, String ageType, int discountPercent, boolean isFree, int providerID) {
        this.childrenDiscountID = childrenDiscountID;
        this.condition = condition;
        this.age = age;
        this.ageType = ageType;
        this.discountPercent = discountPercent;
        this.isFree = isFree;
        this.providerID = providerID;
    }

    public ChildrenDiscountDTO() {
    }

    public ChildrenDiscountDTO(int childrenDiscountID, String condition, int age, String ageType, int discountPercent, boolean isFree) {
        this.childrenDiscountID = childrenDiscountID;
        this.condition = condition;
        this.age = age;
        this.ageType = ageType;
        this.discountPercent = discountPercent;
        this.isFree = isFree;
    }

    public int getChildrenDiscountID() {
        return childrenDiscountID;
    }

    public void setChildrenDiscountID(int childrenDiscountID) {
        this.childrenDiscountID = childrenDiscountID;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

}
