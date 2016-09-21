/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ReferralDTO;
import Interface.DAO.ReferralDAO;
import Mapper.ActivityMapper;
import Mapper.ActivityMapperForHome;
import Mapper.ReferralMapper;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author QuangTran
 */
public class ReferralDAOlmpl implements ReferralDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ReferralDAOlmpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<ReferralDTO> getAllReferrals() {
        String sql = "SELECT * FROM Referral";
        List<ReferralDTO> referrals = jdbcTemplate.query(sql, ReferralMapper.getInstance());
        return referrals;
    }

    @Override
    public boolean insertNewReferral(ReferralDTO referralDTO) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertReferral");
        SqlParameterSource in = new MapSqlParameterSource().addValue("senderId", referralDTO.getSenderID())
                .addValue("receiverEmail", referralDTO.getReceiverEmail()).addValue("sendDate", referralDTO.getSendDate()).addValue("token", referralDTO.getToken())
                .addValue("receiverId", 0).addValue("confirmDate", referralDTO.getSendDate()).addValue("referralStatus", 0);
        simpleJdbcCall.execute(in);
        return true;
    }

}
