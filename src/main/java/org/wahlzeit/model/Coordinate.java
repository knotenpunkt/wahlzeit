package org.wahlzeit.model;

public interface Coordinate {

	public double getDistance(Coordinate c);

	public boolean isEqual(Coordinate c);

	public SphericCoordinate asSphericCoordinate();

	public CartesianCoordinate asCartesianCoordinate();

}
