package org.wahlzeit.model;

public class NullCoordinate extends AbstractCoordinate {

    @Override
    public double getDistance(Coordinate c) {
	throw new CoordinateIsNullException();
    }

	@Override
	public boolean isEqual(Coordinate c) {
		return false; //nullobj !=nullObj nach meiner definition jetzt
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		throw new CoordinateIsNullException();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		throw new CoordinateIsNullException();
	}

    
    
    /*
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
	*/

}
