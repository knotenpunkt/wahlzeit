package org.wahlzeit.model;

import java.io.Serializable;

import org.wahlzeit.services.ObjectManager;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
//@Entity
public class Location implements Serializable{
    
   /* 
    @Id
    Long idLong;
    @Parent
    Key parent = ObjectManager.applicationRootKey;
    */
    
    @Container
    protected Coordinate abstrCoordinate;//= new NullCoordinate();
    
    /**
     * 
     * @return
     * @methodtype getter
     * @methodproperty primitive
     */
    public Coordinate getAbstrCoordinate() {
  	return abstrCoordinate;
  	
      }

    /**
     * 
     * @param abstrCoordinate
     * @methodtype (factory+)getter
     * @methodproperty primitive
     */
      public void setAbstrCoordinate(AbstractCoordinate abstrCoordinate) {
  	this.abstrCoordinate = (abstrCoordinate != null) ? abstrCoordinate : NullCoordinate.getInstance();  	

      }
    

}
