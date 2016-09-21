/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.SubCategoryDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface SubCategoryDAO {

    /**
     * get all sub categories
     *
     * @return list of sub categories
     */
    public List<SubCategoryDTO> getAllSubCategories();
    public List<SubCategoryDTO> getAllSubCategoriesWithinLocation(String location,int categoryID);
}
