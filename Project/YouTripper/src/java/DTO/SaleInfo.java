/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public class SaleInfo {
    private List<BookingDTO> listBookingDTO;
    private List<PackageSale> listPackageDTO;

    public SaleInfo(List<BookingDTO> listBookingDTO, List<PackageSale> listPackageDTO) {
        this.listBookingDTO = listBookingDTO;
        this.listPackageDTO = listPackageDTO;
    }
    
    
    public List<BookingDTO> getListBookingDTO() {
        return listBookingDTO;
    }

    public List<PackageSale> getListPackageDTO() {
        return listPackageDTO;
    }

    public void setListBookingDTO(List<BookingDTO> listBookingDTO) {
        this.listBookingDTO = listBookingDTO;
    }

    public void setListPackageDTO(List<PackageSale> listPackageDTO) {
        this.listPackageDTO = listPackageDTO;
    }
    
    
}
