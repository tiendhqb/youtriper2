/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.EngineBookingDTO;
import DTO.EnginePackageDTO;
import DTO.OfflineBookingDTO;
import DTO.OfflineBookingEngineDTO;
import DTO.OfflinePackageDTO;
import DTO.ResourcesDTO;
import DTO.UsedResourcesViewDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public class BookingEngineData {

    private List<ResourcesDTO> resources;
    private List<EnginePackageDTO> onlinePackages;
    private List<OfflinePackageDTO> offlinePackages;
    private List<EngineBookingDTO> onlineBookings;
//    private List<OfflineBookingEngineDTO> offlineBookings;
    private List<OfflineBookingDTO> offlineBookings;
    private List<UsedResourcesViewDTO> usedResources;

    public BookingEngineData() {
    }

//    public BookingEngineData(List<ResourcesDTO> resources, List<EnginePackageDTO> onlinePackages, List<OfflinePackageDTO> offlinePackages, List<EngineBookingDTO> onlineBookings, List<OfflineBookingEngineDTO> offlineBookings, List<UsedResourcesViewDTO> usedResources) {
//        this.resources = resources;
//        this.onlinePackages = onlinePackages;
//        this.offlinePackages = offlinePackages;
//        this.onlineBookings = onlineBookings;
//        this.offlineBookings = offlineBookings;
//        this.usedResources = usedResources;
//    }
    public BookingEngineData(List<ResourcesDTO> resources, List<EnginePackageDTO> onlinePackages, List<EngineBookingDTO> onlineBookings, List<OfflineBookingDTO> offlineBookings, List<UsedResourcesViewDTO> usedResources) {
        this.resources = resources;
        this.onlinePackages = onlinePackages;
        this.onlineBookings = onlineBookings;
        this.offlineBookings = offlineBookings;
        this.usedResources = usedResources;
    }

    public List<ResourcesDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesDTO> resources) {
        this.resources = resources;
    }

    public List<EnginePackageDTO> getOnlinePackages() {
        return onlinePackages;
    }

    public void setOnlinePackages(List<EnginePackageDTO> onlinePackages) {
        this.onlinePackages = onlinePackages;
    }

    public List<OfflinePackageDTO> getOfflinePackages() {
        return offlinePackages;
    }

    public void setOfflinePackages(List<OfflinePackageDTO> offlinePackages) {
        this.offlinePackages = offlinePackages;
    }

    public List<EngineBookingDTO> getOnlineBookings() {
        return onlineBookings;
    }

    public void setOnlineBookings(List<EngineBookingDTO> onlineBookings) {
        this.onlineBookings = onlineBookings;
    }

    public List<OfflineBookingDTO> getOfflineBookings() {
        return offlineBookings;
    }

    public void setOfflineBookings(List<OfflineBookingDTO> offlineBookings) {
        this.offlineBookings = offlineBookings;
    }

    public List<UsedResourcesViewDTO> getUsedResources() {
        return usedResources;
    }

    public void setUsedResources(List<UsedResourcesViewDTO> usedResources) {
        this.usedResources = usedResources;
    }

}
