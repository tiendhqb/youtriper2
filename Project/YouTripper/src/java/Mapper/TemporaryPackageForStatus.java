/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryPackageForStatus implements RowMapper<TemporaryPackageDTO> {

    private static TemporaryPackageForStatus instance = null;

    private TemporaryPackageForStatus() {
    }

    public static TemporaryPackageForStatus getInstance() {
        if (instance == null) {
            instance = new TemporaryPackageForStatus();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTO mapRow(ResultSet rs, int i) throws SQLException {

        int id = rs.getInt("TemporaryPackageID");
        String name = rs.getString("Name");
        String coverImage = rs.getString("CoverImage");
        String City = rs.getString("City");
        double price = rs.getDouble("OrdinaryPriceForAdult");
        String mainDescription = rs.getString("MainDescription");
        boolean isFinished = rs.getBoolean("isFinished");
        boolean isUsingMaxQuota = rs.getBoolean("isUsingMaxQuota");
        String keywords = rs.getString("Keywords");
        String providerImage = rs.getString("ProviderImage");
        String lastName = rs.getString("LastName");
        int providerID = rs.getInt("ProviderID");
        
        long createdTime = rs.getLong("CreatedTime");
       
        System.out.println(createdTime);
        
        TemporaryPackageDTO packageDTO = new TemporaryPackageDTO(id,name,coverImage,City, 
                price,mainDescription,isFinished,isUsingMaxQuota,keywords,providerImage,lastName,providerID, createdTime);
        return packageDTO;
    }

}
