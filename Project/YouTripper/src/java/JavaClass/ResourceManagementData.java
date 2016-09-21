/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.BusinessResourceDTO;
import DTO.PackageDTO;
import DTO.ResourceSkillDTO;
import DTO.TemporaryPackageDTO;
import DTO.TrippSourceDTO;
import java.util.List;

/**
 *
 * @author Long Nguyen
 */
public class ResourceManagementData {
    private List<ResourceSkillDTO> resourceSkills;
    private List<PackageDTO> packages;
    private List<TemporaryPackageDTO> temporaryPackages;
    private List<BusinessResourceDTO> providerResources;
    private List<TrippSourceDTO> trippSources;

    public ResourceManagementData() {
    }

    public ResourceManagementData(List<ResourceSkillDTO> resourceSkills, List<PackageDTO> packages, List<TemporaryPackageDTO> temporaryPackages, List<BusinessResourceDTO> providerResources, List<TrippSourceDTO> trippSources) {
        this.resourceSkills = resourceSkills;
        this.packages = packages;
        this.temporaryPackages = temporaryPackages;
        this.providerResources = providerResources;
        this.trippSources = trippSources;
    }

    public List<ResourceSkillDTO> getResourceSkills() {
        return resourceSkills;
    }

    public void setResourceSkills(List<ResourceSkillDTO> resourceSkills) {
        this.resourceSkills = resourceSkills;
    }

    public List<PackageDTO> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageDTO> packages) {
        this.packages = packages;
    }

    public List<TemporaryPackageDTO> getTemporaryPackages() {
        return temporaryPackages;
    }

    public void setTemporaryPackages(List<TemporaryPackageDTO> temporaryPackages) {
        this.temporaryPackages = temporaryPackages;
    }

    public List<BusinessResourceDTO> getProviderResources() {
        return providerResources;
    }

    public void setProviderResources(List<BusinessResourceDTO> providerResources) {
        this.providerResources = providerResources;
    }

    public List<TrippSourceDTO> getTrippSources() {
        return trippSources;
    }

    public void setTrippSources(List<TrippSourceDTO> trippSources) {
        this.trippSources = trippSources;
    }
    
    
}
