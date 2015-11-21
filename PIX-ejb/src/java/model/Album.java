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
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Ables
 */
public class Album implements Serializable{
    Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PixUser getUser() {
        return user;
    }

    public void setUser(PixUser user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
    
    public boolean getIsNew(){
    return getId() == null;
    }
    
    public String toString(){
    return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
       int result = super.hashCode(); //To change body of generated methods, choose Tools | Templates.
        final int PRIME = 31;
        result = PRIME * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = PRIME * result +((description == null) ? 0: description.hashCode());
        result = PRIME * result +((id == null) ? 0 :id.hashCode());
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        
    }
    
    
}
