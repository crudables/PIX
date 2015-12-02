/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ables.pix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.stream.events.Comment;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author Ables
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PixUser implements Serializable {
    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private List<Album> albums = new ArrayList<Album>();
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<Comment>();

    public PixUser() {
    }

    public PixUser(String username, String firstName, String lastName, String email, String password) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    
    @Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((email == null) ? 0 : email.hashCode());
		result = PRIME * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = PRIME * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = PRIME * result
				+ ((password == null) ? 0 : password.hashCode());
		result = PRIME * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PixUser other = (PixUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
        
        public String toString() {
	   return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
        
        public void addAlbum(Album album){
        album.setUser(this);
        getAlbums().add(album);
        }
        
        public void addCooment(Comment comment){}
}
