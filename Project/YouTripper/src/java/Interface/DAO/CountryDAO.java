/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.CountryDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface CountryDAO {
    public List<CountryDTO> getAllCountry();
}
