/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import junit.framework.TestCase;
import model.PixUser;

/**
 *
 * @author Ables
 */
public class PixUserTest extends TestCase {
    private PixUser[] testUser;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        testUser = new PixUser[2];
        testUser[0] = new PixUser("joe", "smoe", "joes", "joes@natat.com", "joe123");
        testUser[1] = new PixUser("alansey", "Sheret", "Alan", "Alasheet@ymail.com", "sheret321");
    }
    
    public void testFields(){
    PixUser user = testUser[0];
        assertEquals("joe", user.getUsername());
        assertEquals("smoe", user.getFirstName());
        assertEquals("joes", user.getLastName());
    }
}
