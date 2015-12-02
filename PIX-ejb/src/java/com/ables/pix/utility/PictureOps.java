/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ables.pix.utility;

import com.ables.pix.model.Picture;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
    private static double angle;

    public static double getAngle() {
        return angle;
    }

    public static void setAngle(double angle) {
        PictureOps.angle = angle;
    }

    
    

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
    
    public static BufferedImage tilt(BufferedImage image, double rotation){
    double sin = Math.abs(Math.sin(getAngle()));
    double cos = Math.abs(Math.cos(getAngle()));
    int w = image.getWidth(), h = image.getHeight();
    
    int neww =(int) Math.floor(w*cos + sin*h), newh = (int)Math.floor(h*cos+sin*w);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage rotated = gc.createCompatibleImage(neww, newh);
        Graphics2D g = rotated.createGraphics();
        g.translate((neww-w)/2, (newh-h/2));
        g.rotate(getAngle(),w/2,h/2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return rotated;
    }
    
    public static GraphicsConfiguration getDefaultConfiguration(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    
    }
        public UploadStatus storePicture(PictureUpload upload){
            if((upload.getAlbumId() == null) || upload.getUpload() == null || repositoryRoot == null){
            throw  new IllegalArgumentException("A picture cannot be stored if the album ID or file is not provided.");
            }
            
            StringBuffer target = new StringBuffer();
            target.append("album");
            target.append(File.separator);
            target.append(upload.getAlbumId());
            target.append(File.separator);
            
            // Set the relative file location here.
            
            String path = target.toString();
            target.insert(0, this.repositoryRoot);
            
            
            // Create album folder if it doesn't exist.
            
            File dir = new File(target.toString());
            if(!dir.exists()){
            dir.mkdir();
            }
            
            String fileName = upload.getUpload().getOriginalFilename();
            if(fileName == null || "".equals(fileName)){
               fileName =   upload.getUpload().getName();
            }
            
            target.append(fileName);
            
            // Check if the picture exists.
            File targetFile = new File(target.toString());
            if(targetFile.exists()){
            if(log.isInfoEnabled()){
            log.info(targetFile +" already exists");
            }
            
            return UploadStatus.EXISTS;
            }
            
            // Mark for automatic deletion on JVM shutdown.
            if(deleteOnShutDown){
            targetFile.deleteOnExit();
            
            // Check if this is a valid image.
            try{
            if(ImageIO.read(upload.getUpload().getInputStream())== null){
            return UploadStatus.INVALID;
            }
            }
            
            catch(IOException io){
            io.printStackTrace();
            return UploadStatus.FAILED;
            }
            }
        }
}
