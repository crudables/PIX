/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ables.pix.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Ables
 */
@Entity
@DiscriminatorValue("PERSONAL")
public class PersonalAlbum extends Album{

    public PersonalAlbum() {
    }

    public PersonalAlbum(String name) {
        super(name);
    }
    
    
}
