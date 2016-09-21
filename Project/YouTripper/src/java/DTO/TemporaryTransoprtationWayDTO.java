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
public class TemporaryTransoprtationWayDTO {

    private int temporaryPackageID;
    private int transporattionID;
    private String transportationName;
    private String transportationImage;
    private String content;

    public TemporaryTransoprtationWayDTO() {
    }

    public TemporaryTransoprtationWayDTO(int temporaryPackageID, int transporattionID, String transportationName, String transportationImage, String content) {
        this.temporaryPackageID = temporaryPackageID;
        this.transporattionID = transporattionID;
        this.transportationName = transportationName;
        this.transportationImage = transportationImage;
        this.content = content;
    }

    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getTransporattionID() {
        return transporattionID;
    }

    public void setTransporattionID(int transporattionID) {
        this.transporattionID = transporattionID;
    }

    public String getTransportationName() {
        return transportationName;
    }

    public void setTransportationName(String transportationName) {
        this.transportationName = transportationName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTransportationImage() {
        return transportationImage;
    }

    public void setTransportationImage(String transportationImage) {
        this.transportationImage = transportationImage;
    }

}
