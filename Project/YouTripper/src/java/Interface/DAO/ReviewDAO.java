/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ReviewDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface ReviewDAO {

    public List<ReviewDTO> getReviewsByTime(int time, int packageID);

    public List<ReviewDTO> getReviewsOfProviderByTime(int time, int providerID);

    public List<ReviewDTO> getReviewsOfTripperByTime(int time, int tripperID);
    
    public boolean checkReviewExist(int tripperID,String bookingID);
    
    public boolean makeReview(int tripperID,String bookingID,int packageID,String review,double rate,String date,int Professionlism,int StaffAttitude,int Convenient,int Satisfaction,int AmenityQuality,int Cleanliness);
}
