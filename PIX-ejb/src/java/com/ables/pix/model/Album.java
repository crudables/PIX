/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ables.pix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Ables
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ALBUM")
@DiscriminatorColumn(name="DTYPE")
@NamedQueries({@NamedQuery(name="useralbums",query = "select a from album where a.user.username = ?1"),
@NamedQuery(name="allalbums",query = "select a from a")
})
public class Album implements Serializable{
    @Id
     @GeneratedValue
  private  Integer id;
   private PixUser user;
   private String description;
   private String name;
   @Temporal(TemporalType.TIMESTAMP)
   private Date creationDate = new Date();
   private String[] labels;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
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
        result = PRIME * result + ((user == null) ? 0 : user.hashCode());
        result = PRIME * result + Arrays.hashCode(labels);
        return result;
    }

@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Album other = (Album) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(labels, other.labels))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}    
    
        public void addPicture(Picture pic){
        pic.setAlbum(this);
        pictures.add(pic);
        }
}
