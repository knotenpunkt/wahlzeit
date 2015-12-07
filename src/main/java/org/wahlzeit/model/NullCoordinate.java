package org.wahlzeit.model;

import java.util.Hashtable;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class NullCoordinate extends AbstractCoordinate {

	private static NullCoordinate instance=new NullCoordinate();
	
	private NullCoordinate(){}
	
	public static NullCoordinate getInstance()
	{
		return instance;
	}
	
	
	
    @Override
    public double getDistanceHa06(Coordinate c) {
	throw new CoordinateIsNullException();
    }

    @Override
    public boolean isEqualHa06(Coordinate c) {
	return false; // nullobj !=nullObj nach meiner definition jetzt
    }

    @Override
    public double getDistance(Coordinate c) {
	throw new CoordinateIsNullException();
    }

    @Override
    public boolean isEqual(Coordinate c) {
	return false; // nullobj !=nullObj nach meiner definition jetzt
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
	throw new CoordinateIsNullException();
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
	throw new CoordinateIsNullException();
    }

    @Override
    public SphericCoordinate accept(DistanceCalculatorVisitor<SphericCoordinate, Void> v, Void ein_weiterer_parameter) {
	throw new CoordinateIsNullException();
    }

    /*
     * @Override public double getLatintudinalDistance(AbstractCoordinate c) {
     * throw new CoordinateIsNullException(); }
     * 
     * @Override public double getLongitudinalDistance(AbstractCoordinate c) {
     * throw new CoordinateIsNullException(); }
     * 
     * @Override public double getLatitude() { throw new
     * CoordinateIsNullException(); }
     * 
     * @Override public void setLatitude(double latitude) { throw new
     * CoordinateIsNullException();
     * 
     * }
     * 
     * @Override public double getLongitude() { throw new
     * CoordinateIsNullException(); }
     * 
     * @Override public void setLongitude(double longitude) { throw new
     * CoordinateIsNullException(); }
     */

}
