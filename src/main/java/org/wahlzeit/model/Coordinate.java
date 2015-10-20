package org.wahlzeit.model;


public interface Coordinate
{
	public Coordinate getDistance(Coordinate c);
	
	public double getLatintudinalDistance(Coordinate c);
	
	public double getLongitudinalDistance(Coordinate c);

	public double getLatitude();
	public void setLatitude(double latitude);
	public double getLongitude();
	public void setLongitude(double longitude);
}
