/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.AdditionImageDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nick
 */
public class AdditionalImages implements Serializable {
    private int maximumNumber;
    private List<AdditionImageDTO> images;
   

    public AdditionalImages() {
    }

    public AdditionalImages(int maximumNumber, List<AdditionImageDTO> images) {
        this.maximumNumber = maximumNumber;
        this.images = images;
    }

    public int getMaximumNumber() {
        return maximumNumber;
    }

    public void setMaximumNumber(int maximumNumber) {
        this.maximumNumber = maximumNumber;
    }

    public List<AdditionImageDTO> getImages() {
        return images;
    }

    public void setImages(List<AdditionImageDTO> images) {
        this.images = images;
    }

   
}
