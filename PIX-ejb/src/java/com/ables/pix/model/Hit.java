/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ables.pix.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ables
 */
public class Hit implements Serializable{
    
    long id;
    private Date dateOfHit;
    private boolean resultedInNewRegistration;

    public Hit(Date dateOfHit, boolean resultedInNewRegistration) {
        this.dateOfHit = dateOfHit;
        this.resultedInNewRegistration = resultedInNewRegistration;
    }

    public boolean isResultedInNewRegistration() {
        return resultedInNewRegistration;
    }

    public void setResultedInNewRegistration(boolean resultedInNewRegistration) {
        this.resultedInNewRegistration = resultedInNewRegistration;
    }

    public Date getDateOfHit() {
        return dateOfHit;
    }

    public void setDateOfHit(Date dateOfHit) {
        this.dateOfHit = dateOfHit;
    }
    
    
}
