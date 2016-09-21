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
public class TransportationDTO {
    private int transportationID;
    private String name;
    private String content;
    private String image;

    public TransportationDTO() {
    }

    public TransportationDTO(int transportationID, String name) {
        this.transportationID = transportationID;
        this.name = name;
    }

    public TransportationDTO(int transportationID, String name, String content, String image) {
        this.transportationID = transportationID;
        this.name = name;
        this.content = content;
        this.image = image;
    }
    
    public TransportationDTO(int transportationID, String name, String content) {
        this.transportationID = transportationID;
        this.name = name;
        this.content = content;
    }

    public int getTransportationID() {
        return transportationID;
    }

    public void setTransportationID(int transportationID) {
        this.transportationID = transportationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
