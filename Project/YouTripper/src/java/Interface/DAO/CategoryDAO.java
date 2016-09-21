/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.CategoryDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface CategoryDAO {
    /**
     * get all categories
     *
     * @return list of all categories
     */
    public List<CategoryDTO> getAllCategories();
}
