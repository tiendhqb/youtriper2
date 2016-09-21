/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import java.util.List;

/**
 *
 * @author Nick
 */
public interface SystemKeywordDAO {

    public void insertKeyword(String keyword);

    public List<String> getSuggestionKeywords(String keyword, List<String> oldKeywords, int noKeywords);
    
    public void updateKeywordByPackage(int packageID);
}
