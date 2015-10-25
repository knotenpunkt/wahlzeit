package org.wahlzeit.model;

public class NullCoordinate implements AbstractCoordinate {

    @Override
    public AbstractCoordinate getDistance(AbstractCoordinate c) {
	throw new CoordinateIsNullException();
    }

    @Override
    public double getLatintudinalDistance(AbstractCoordinate c) {
	throw new CoordinateIsNullException();
    }

    @Override
    public double getLongitudinalDistance(AbstractCoordinate c) {
	throw new CoordinateIsNullException();
    }

    @Override
    public double getLatitude() {
	throw new CoordinateIsNullException();
    }

    @Override
    public void setLatitude(double latitude) {
	throw new CoordinateIsNullException();

    }

    @Override
    public double getLongitude() {
	throw new CoordinateIsNullException();
    }

    @Override
    public void setLongitude(double longitude) {
	throw new CoordinateIsNullException();
    }

}
