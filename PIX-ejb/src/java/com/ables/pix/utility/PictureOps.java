/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ables.pix.utility;

import com.ables.pix.model.Picture;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 *
 * @author ables
 */
public class PictureOps {
    public enum UploadStatus{
    SUCCESS,EXISTS,INVALID, FAILED
    }
    
    private Log log  = LogFactory.getLog(PictureOps.class);
    private String repositoryRoot = System.getProperty("webapp.root");
    private boolean deleteOnShutDown = true;
    private final double LEFT = Math.toRadians(-90);
    private final double RIGHT = Math.toRadians(90);

    public void deletePicture(Picture picToDelete){
    File fileToDelete =  new File(repositoryRoot+picToDelete.getPath());
    fileToDelete.delete();
    }
    
    public void rotatePictureLeft(Picture pic){
        rotatePicture(pic,LEFT);
    }
    
    public void rotatePictureRight(Picture pic){
    rotatePicture(pic,RIGHT);
    }
    
    private void rotatePicture(Picture pic, double rotation){
        ResourceLoader loader = new FileSystemResourceLoader();
        Resource resource = loader.getResource(repositoryRoot+pic.getLocation());
        BufferedImage image;
        try{
        image = ImageIO.read(resource.getFile());
        BufferedImage result = tilt(image,rotation);
        String fileName = pic.getFileName();
        ImageIO.write(result, fileName.substring(fileName.indexOf('.'+1)), new File(resource.getFile().toURI()));
        }
        
        catch(IOException io){
        throw  new RuntimeException("Failed to rotate image",io);
        }
    }
    
    private BufferedImage createThumb(BufferedImage image){
    return image;
    }
    
    public static void tilt(BufferedImage image, double rotation){
    
    }
}
