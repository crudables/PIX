/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ables.pix.service;

import java.util.List;
import com.ables.pix.model.Album;
import com.ables.pix.model.Picture;
import com.ables.pix.model.PixUser;
import com.ables.pix.utility.PictureUpload;

/**
 *
 * @author ables
 */
public interface PersistenceService {
    
    public enum uploadStatus{
    SUCCESS,EXIST,INVALID,FAILED
    }
    public void persistUser(PixUser user);
    
    public PixUser retrieveUser(String username);    
    
    public void deleteUser(PixUser user);
    
    public void deletePicture(Picture picture);
    
    public uploadStatus storePicture(PictureUpload picture);
    
//    public void rotatePictureRight(Picture picture);
//    
//    public void rotatePictureLeft(Picture picture);
    
    public Album retrieveAlbumById(Integer id);
    
    public void persistAlbum(Album album);
    
    public void deleteAlbum(Album album);
    
    public List<Album> retrieveUserAlbum(PixUser user);
    
    public List<Album>retrieveAllAlbums();
    
    public void removePictureFromAlbum(Integer id);
    
//    public Picture retrievePictureById(Integer id);
    
}