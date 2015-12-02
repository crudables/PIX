/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ables.pix.utility;

import com.ables.pix.model.Picture;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ables
 */
public class PictureUpload {
  private Integer albumId;
    private MultipartFile upload;
    private Picture picture;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public MultipartFile getUpload() {
        return upload;
    }

    public void setUpload(MultipartFile upload) {
        this.upload = upload;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
