/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ReferralDTO;
import java.util.List;
/**
 *
 * @author QuangTran
 */
public interface ReferralDAO {
    public List<ReferralDTO> getAllReferrals();
    
    public boolean insertNewReferral(ReferralDTO referralDTO);
}
