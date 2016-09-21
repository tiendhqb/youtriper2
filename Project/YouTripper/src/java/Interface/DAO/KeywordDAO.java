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
public interface KeywordDAO {

    /**
     *
     * @param data get data from user
     * @return list keywords contains data
     */
    public List<String> getKeywords(String data);
    
    public boolean insertNewKeyword(String keyword, String IP, String date);
    
    public boolean insertNewSystemKeyword(String keyword,int times);
    
    public boolean deleteKeywordCollection(String keyword);
    
    public boolean deleteAllKeywordCollection();
}
