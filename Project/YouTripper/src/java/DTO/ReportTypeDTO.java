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
public class ReportTypeDTO {
    private int reportTypeID;
    private String name;

    public ReportTypeDTO(int reportTypeID, String name) {
        this.reportTypeID = reportTypeID;
        this.name = name;
    }
    
    public int getReportTypeID() {
        return reportTypeID;
    }

    public String getName() {
        return name;
    }

    public void setReportTypeID(int reportTypeID) {
        this.reportTypeID = reportTypeID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
