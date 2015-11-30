package org.wahlzeit.model;

import java.io.Serializable;

import org.wahlzeit.Pattern;

import com.googlecode.objectify.annotation.Entity;

@Pattern(
		name = "Visitor", 
		participants = { 
				"Element" //gibt das Visitable-Interface weiter
		}
)
public interface Coordinate extends Serializable, Visitable<SphericCoordinate, Void, SphericCoordinate, Void> {

    /**
     * 
     * @param c
     * @return
     * 
     * @methodtype get
     */
    public double getDistanceHa06(Coordinate c);

    /**
     * 
     * @param c
     * @return
     * 
     * @methodtype comparsion
     */
    public boolean isEqualHa06(Coordinate c);

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
