/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.RemindReviewEmail;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface RemindReviewEmailDAO {
    public List<RemindReviewEmail> getBookingList();
}
