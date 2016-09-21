/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackagesViewDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackagesViewMapperWithNewStatus implements RowMapper<PackagesViewDTO> {

    private static PackagesViewMapperWithNewStatus instance = null;

    private PackagesViewMapperWithNewStatus() {
    }

    public static PackagesViewMapperWithNewStatus getInstance() {
        if (instance == null) {
            instance = new PackagesViewMapperWithNewStatus();
        }
        return instance;
    }

    @Override
    public PackagesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        int packageID = rs.getInt("PackageID");
        String name = rs.getString("Name");
        String mainDescription = "";
        String keywords = "";
        String coverImage = rs.getString("CoverImage");
        String location = rs.getString("City");
        double rate = rs.getDouble("Rate");
        int numberRate = rs.getInt("NumberRate");
        double price = rs.getDouble("OrdinaryPriceForAdult");
        int providerID = rs.getInt("ProviderID");
        String lastName = rs.getString("LastName");
        String providerImage = rs.getString("ProviderImage");
        int totalRecords = 0;
//        String packageStatus = "";
//        int tempStatus = rs.getInt("PackageStatus");
//        if(tempStatus == 2){
//            packageStatus = "approved";
//        }else if(tempStatus == 1){
//            packageStatus = "pending";
//        }else {
//            packageStatus = "creating";
//        }
        boolean isPending = rs.getBoolean("isPending");
        boolean isStopped = rs.getBoolean("isStopped");
        boolean isDeleting = rs.getBoolean("isDeleting");
        boolean isEditing = rs.getBoolean("isEditing");
        boolean isUsingMaxQuota = rs.getBoolean("isUsingMaxQuota");
        int NoTrippSources = rs.getInt("NoTrippSources");

        long createdTime = rs.getLong("CreatedTime");
 
        return new PackagesViewDTO(packageID, name, mainDescription, keywords, coverImage, location, rate, numberRate, price, providerID, lastName, providerImage, totalRecords, isPending, isStopped, isDeleting, isEditing, isUsingMaxQuota, NoTrippSources,createdTime);
    }

}
