package org.wahlzeit.model;

/**
 * @author robin
 *
 */
public class Coordinate extends AbstractCoordinate {

    private double latitude = 0;
    private double longitude = 0;

    /**
     * @param lat
     * @param longi
     */
    public Coordinate(double varLat, double varLong) {
	this.setLatitude(varLat);
	this.setLongitude(varLong);
    }

    @Override
    public double getDistance(AbstractCoordinate c) {
	
	return Math.acos(Math.sin(this.latitude)*
		Math.sin(c.getLatitude()) + 
		Math.cos(this.latitude)*
		Math.cos(c.getLatitude())*
		Math.cos(Math.abs(c.getLongitude()-this.longitude)));
	//return new Coordinate(Math.abs(this.latitude - c.getLatitude()), Math.abs(this.longitude - c.getLongitude()));
    }

    @Override
    public double getLatintudinalDistance(AbstractCoordinate c) {
	return Math.abs(this.latitude - c.getLatitude());
    }

    @Override
    public double getLongitudinalDistance(AbstractCoordinate c) {
	return Math.abs(this.longitude - c.getLongitude());
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	if(latitude<0)throw new IllegalArgumentException("latitude<0 not allowed");
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	if(longitude<0)throw new IllegalArgumentException("longitude<0 not allowed");
	this.longitude = longitude;
    }

}
