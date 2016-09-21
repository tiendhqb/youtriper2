/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ReferralDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author QuangTran
 */
public class ReferralMapper implements RowMapper<ReferralDTO>{
    
    private static ReferralMapper instance = null;

    public ReferralMapper() {
    }
    public static ReferralMapper getInstance() {
        if (instance == null) {
            instance = new ReferralMapper();
        }
        return instance;
    }
    
    @Override
    public ReferralDTO mapRow(ResultSet rs, int i) throws SQLException {
        ReferralDTO referralDTO = new ReferralDTO(rs.getInt("SenderID"), rs.getInt("ReceiverID"), rs.getString("ReceiverEmail"), rs.getString("SendDate"), rs.getString("Token"), rs.getString("ConfirmDate"));
        return referralDTO;
    }
}
