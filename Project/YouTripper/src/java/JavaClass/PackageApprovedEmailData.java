/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author DINH KHANG
 */
public class PackageApprovedEmailData {
    private String lastName;
    private String email;
    private String lastestPackageName;

    public PackageApprovedEmailData(String lastName, String email, String lastestPackageName) {
        this.lastName = lastName;
        this.email = email;
        this.lastestPackageName = lastestPackageName;
    }   
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastestPackageName() {
        return lastestPackageName;
    }

    public void setLastestPackageName(String lastestPackageName) {
        this.lastestPackageName = lastestPackageName;
    }
    
    
}
