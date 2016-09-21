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
 * @author Nick
 */
public class PackagesViewMapper implements RowMapper<PackagesViewDTO> {

    private static PackagesViewMapper instance = null;

    private PackagesViewMapper() {
    }

    public static PackagesViewMapper getInstance() {
        if (instance == null) {
            instance = new PackagesViewMapper();
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
        String priceCurrency = rs.getString("PriceCurrency");
        return new PackagesViewDTO(priceCurrency, packageID, name, mainDescription, keywords, coverImage, location, rate, numberRate, price, providerID, lastName, providerImage, totalRecords);
    }

}
