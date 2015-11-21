/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ables
 */
public class Album implements Serializable{
    PixUser user;
    String description;
    String name;
    Date creationDate = new Date();
    String[] labels;
    
    private List<Picture> pictures  = new ArrayList<Picture>();

    public Album() {
    }

    public Album(String name) {
        this.name = name;
    }
    
    
}
