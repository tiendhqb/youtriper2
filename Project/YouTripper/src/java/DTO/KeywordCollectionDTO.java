/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class KeywordCollectionDTO {
    private String keyword;
    private int times;

    public KeywordCollectionDTO(String keyword, int times) {
        this.keyword = keyword;
        this.times = times;
    }
   
    
    public String getKeyword() {
        return keyword;
    }

    public int getTimes() {
        return times;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setTimes(int times) {
        this.times = times;
    }
    
}
