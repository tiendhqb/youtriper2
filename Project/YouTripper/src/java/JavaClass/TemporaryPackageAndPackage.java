/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.DeleteReasonDTO;
import DTO.PackagesViewDTO;
import DTO.TemporaryPackageDTO;
import java.util.List;


/**
 *
 * @author Administrator
 */
public class TemporaryPackageAndPackage {
    private List<PackagesViewDTO> listPackage;
    private List<TemporaryPackageDTO> listTemporaryPackage;
    private List<DeleteReasonDTO> listDeleteReason;
    
    public List<PackagesViewDTO> getListPackage() {
        return listPackage;
    }

    public void setListPackage(List<PackagesViewDTO> listPackage) {
        this.listPackage = listPackage;
    }

    public List<TemporaryPackageDTO> getListTemporaryPackage() {
        return listTemporaryPackage;
    }

    public void setListTemporaryPackage(List<TemporaryPackageDTO> listTemporaryPackage) {
        this.listTemporaryPackage = listTemporaryPackage;
    }

    /**
     * @return the listDeleteReason
     */
    public List<DeleteReasonDTO> getListDeleteReason() {
        return listDeleteReason;
    }

    /**
     * @param listDeleteReason the listDeleteReason to set
     */
    public void setListDeleteReason(List<DeleteReasonDTO> listDeleteReason) {
        this.listDeleteReason = listDeleteReason;
    }
}
