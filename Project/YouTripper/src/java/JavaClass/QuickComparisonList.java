/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.PackageDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public class QuickComparisonList {
    List<PackageDTO> comparisonList;
    List<PackageDTO> comparisonListSameLocation;

    public QuickComparisonList(List<PackageDTO> comparisonList, List<PackageDTO> comparisonListSameLocation) {
        this.comparisonList = comparisonList;
        this.comparisonListSameLocation = comparisonListSameLocation;
    }

    
    public List<PackageDTO> getComparisonList() {
        return comparisonList;
    }

    public void setComparisonList(List<PackageDTO> comparisonList) {
        this.comparisonList = comparisonList;
    }

    public List<PackageDTO> getComparisonListSameLocation() {
        return comparisonListSameLocation;
    }

    public void setComparisonListSameLocation(List<PackageDTO> comparisonListSameLocation) {
        this.comparisonListSameLocation = comparisonListSameLocation;
    }
    
}
