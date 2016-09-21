/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Long Nguyen
 */
public class TrippSourceDTO {

    private int trippSourceID;
    private int packageID;
    private String packageName;
    private String type;
    private int noSkills;
    private int skillID;
    private int hours;
    private int minutes;
    private int days;
    private int noUnits;

    public TrippSourceDTO() {
    }

    public TrippSourceDTO(int trippSourceID, int packageID, String packageName, String type, int noSkills, int skillID, int hours, int minutes, int days, int noUnits) {
        this.trippSourceID = trippSourceID;
        this.packageID = packageID;
        this.type = type;
        this.noSkills = noSkills;
        this.skillID = skillID;
        this.hours = hours;
        this.minutes = minutes;
        this.days = days;
        this.noUnits = noUnits;
        this.packageName = packageName;
    }

    public int getTrippSourceID() {
        return trippSourceID;
    }

    public void setTrippSourceID(int trippSourceID) {
        this.trippSourceID = trippSourceID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoSkills() {
        return noSkills;
    }

    public void setNoSkills(int noSkills) {
        this.noSkills = noSkills;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNoUnits() {
        return noUnits;
    }

    public void setNoUnits(int noUnits) {
        this.noUnits = noUnits;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
