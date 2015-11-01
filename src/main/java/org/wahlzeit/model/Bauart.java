package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;

//@Entity
public abstract class Bauart implements Serializable {
    
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract String getName();
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract String getDescription();
    //...
    
    

}
