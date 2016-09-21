/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackagesViewDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackagesViewMapperWithStatus implements RowMapper<PackagesViewDTO> {

    private static PackagesViewMapperWithStatus instance = null;

    private PackagesViewMapperWithStatus() {
    }

    public static PackagesViewMapperWithStatus getInstance() {
        if (instance == null) {
            instance = new PackagesViewMapperWithStatus();
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
        String packageStatus = "";
        int tempStatus = rs.getInt("PackageStatus");
        if (tempStatus == 2) {
            packageStatus = "approved";
        } else if (tempStatus == 1) {
            packageStatus = "pending";
        } else {
            packageStatus = "creating";
        }
        return new PackagesViewDTO(packageID, name, mainDescription, keywords, coverImage, location, rate, numberRate, price, providerID, lastName, providerImage, totalRecords, packageStatus);
    }

}
