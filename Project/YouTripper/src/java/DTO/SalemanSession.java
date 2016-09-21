/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author QuangTran
 */
public class SalemanSession {
    private int salesmanId;
    private String name;    
    private int role;

    public SalemanSession() {
        this.role = 4;
    }

    public SalemanSession(int salesmanId, String name, int role) {
        this.salesmanId = salesmanId;
        this.name = name;
        this.role = 4;
    }

    
    /**
     * @return the salesmanId
     */
    public int getSalesmanId() {
        return salesmanId;
    }

    /**
     * @param salesmanId the salesmanId to set
     */
    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }
    
    
}
