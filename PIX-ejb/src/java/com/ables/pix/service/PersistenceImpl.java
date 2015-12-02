/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ables.pix.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.ables.pix.model.Album;
import com.ables.pix.model.Picture;
import com.ables.pix.model.PixUser;
import com.ables.pix.utility.PictureUpload;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ables
 */
@Repository
public class PersistenceImpl implements PersistenceService{
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void persistUser(PixUser user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public PixUser retrieveUser(String username) {
        return entityManager.find(PixUser.class, username);
    }

    @Override
    @Transactional
    public void deleteUser(PixUser user) {
        entityManager.remove(user);
    }

    @Override
    public void deletePicture(Picture picture) {
        
    }

//    @Override
//    public uploadStatus storePicture(PictureUpload picture) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void rotatePictureRight(Picture picture) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void rotatePictureLeft(Picture picture) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Album retrieveAlbumById(Integer id) {
        return entityManager.find(Album.class, id);
    }

    @Override
    public void persistAlbum(Album album) {
        entityManager.persist(album);
    }

    @Override
    public void deleteAlbum(Album album) {
        entityManager.remove(album);
    }

    @Override
    public List<Album> retrieveUserAlbum(PixUser user) {
        Query query = entityManager.createNamedQuery("userAlbums");
        query.setParameter(1, user.getUsername());
        return query.getResultList();
    }

    @Override
    public List<Album> retrieveAllAlbums() {
        Query query = entityManager.createNamedQuery("allAlbums");
        return query.getResultList();
    }

    @Override
    public void removePictureFromAlbum(Integer id) {
        Query query = entityManager.createNamedQuery("deletePicture");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public uploadStatus storePicture(PictureUpload picture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
