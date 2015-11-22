/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ables
 */
public class Affiliate extends PixUser{
    private String companyName;
    private String faxNumber;
    private String websiteUrl;

    public Affiliate() {
    }

    public Affiliate(String companyName, String faxNumber, String websiteUrl, String username, String firstName, String lastName, String email, String password) {
        super(username, firstName, lastName, email, password);
        this.companyName = companyName;
        this.faxNumber = faxNumber;
        this.websiteUrl = websiteUrl;
        setWebsiteUrl(websiteUrl);
        setFaxNumber(faxNumber);
        setCompanyName(companyName);
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    
    
}
