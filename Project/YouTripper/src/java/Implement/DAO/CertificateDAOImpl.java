/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.CertificateDTO;
import DTO.ProviderDTO;
import Interface.DAO.CertificateDAO;
import Mapper.AddCertificateDTOMapper;
import Mapper.CertificateAdminDTOMapper;
import Mapper.CertificateDTOMapper;
import Mapper.ProviderPassportMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class CertificateDAOImpl implements CertificateDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    private final Gson gson;

    public CertificateDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
        gson = new Gson();
    }

    @Override
    public List<CertificateDTO> insertNewCertificates(int providerID, String image, String name) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertAddCertificate").returningResultSet("rs1", AddCertificateDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("image", image).addValue("name", name);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<CertificateDTO> certificateDTOs = (List<CertificateDTO>) record.get("rs1");
        return certificateDTOs;
    }

    @Override
    public List<CertificateDTO> getCertificate() {
        String sql = "Select Certificate.*,Provider.LastName From Certificate,Provider Where (isApproved=0 Or isApproved is null) AND Certificate.ProviderID = Provider.ProviderID";
        return (List<CertificateDTO>) jdbcTemplate.query(sql, CertificateAdminDTOMapper.getInstance());
    }

    @Override
    public boolean approveCertificate(Object[] setCertificateId, String sqlPlus) {
        String sql = "Update Certificate Set isApproved=1 Where CertificateID = ?" + sqlPlus;
        jdbcTemplate.update(sql, setCertificateId);
        return true;
    }

    @Override
    public boolean approvePassport(String sqlPlus, Object[] providerIDArr) {
//        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
//        int length = jsonObject.get("providerIDSize").getAsInt();
//        Object[] providerIDArr = new Object[length];
//        String sqlPlus = "";
//        int providerID = 0;
//        int i;
//        for( i = 2; i <= length; i++){
//            sqlPlus += " OR ProviderID = ?";
//        }
//        for( i = 1; i <= length; i++){
//            providerID = jsonObject.get("providerID" + i).getAsInt();
//            providerIDArr[i-1] = providerID;
//        }
        String sql = "Update Provider Set PassportStatus=1 Where ProviderID = ?" + sqlPlus;
        jdbcTemplate.update(sql,providerIDArr);

        return true;
    }

    @Override
    public List<ProviderDTO> getCreatedPassport() {
        String sql = "SELECT ProviderID, FirstName, Image, PassportImage, PassportStatus, BusinessName, Email, PassportUploadTime"
                + " FROM Provider"
                + " WHERE PassportStatus = ? OR PassportStatus IS NULL AND PassportImage IS NOT NULL";
//               
        return jdbcTemplate.query(sql, ProviderPassportMapper.getInstance(), false);
    }

}
