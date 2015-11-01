package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.ObjectManager;

import com.google.appengine.api.datastore.Key;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class PhotoHausTest {

    private PhotoHaus testobj;
    private double delta = 0.00001;

    @Before
    public void initPhotoHaus() {
	//testobj=new PhotoHaus(new PhotoId(1));
	testobj=new PhotoHaus();
	
	/**
	 * Um diesen Test ausfueren zu koennen	 * 
	 * => Key parent = ObjectManager.applicationRootKey; in Photo Klasse auskommentieren!!!!
	 */
	
    }

    /**
     *
     */
    @Test
    public void testGetGesamtVolumen() {
	
	ConcreteRoom concreteRoom = new ConcreteRoom();
	concreteRoom.setVolumen(30);
	
	ConcreteRoom concreteRoom2 = new ConcreteRoom();
	concreteRoom2.setVolumen(40);
	
	testobj.addRoom(concreteRoom);
	testobj.addRoom(concreteRoom2);
	testobj.addRoom(concreteRoom);
	
	
	assertEquals(100, testobj.getGesamtHausvolumen());
	
    }
    
    @Test
    public void testBurnDown()
    {
	testobj.setBauart(new BauartBarock());
	testobj.setWert(50);
	testobj.setFensterCounter(60);
	
	testobj.burnDown();
	assertEquals(0, testobj.getWert());
	assertEquals(0, testobj.getFensterCounter());	
	assertTrue(testobj.getBauart() instanceof BurnDownStil);
	
    }

 

}
