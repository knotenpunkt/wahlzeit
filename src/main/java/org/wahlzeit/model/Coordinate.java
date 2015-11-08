package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;

public interface Coordinate extends Serializable, Visitable<SphericCoordinate, Void, SphericCoordinate, Void> {

    /**
     * 
     * @param c
     * @return
     * 
     * @methodtype get
     */
    public double getDistance(Coordinate c);

    /**
     * 
     * @param c
     * @return
     * 
     * @methodtype comparsion
     */
    public boolean isEqual(Coordinate c);

    /**
     * 
     * @return
     * 
     * @methodtype conversion
     */
    public SphericCoordinate asSphericCoordinate();

    /**
     * 
     * @return
     * 
     * @methodtype conversion
     */
    public CartesianCoordinate asCartesianCoordinate();

}
