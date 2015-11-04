package org.wahlzeit.model;

/**
 * @author robin
 *
 */
public class SphericCoordinate extends AbstractCoordinate{

    private double latitude = 0;
    private double longitude = 0;

    /**
     * @param lat
     * @param longi
     */
    public SphericCoordinate(double varLat, double varLong) {
	this.setLatitude(varLat);
	this.setLongitude(varLong);
    }

    @Override
    public double getDistance(Coordinate c) {
    	
    	
    	SphericCoordinate sc= c.asSphericCoordinate();   	
	
	return Math.acos(Math.sin(this.latitude)*
		Math.sin(sc.getLatitude()) + 
		Math.cos(this.latitude)*
		Math.cos(sc.getLatitude())*
		Math.cos(Math.abs(sc.getLongitude()-this.longitude)));
	//return new Coordinate(Math.abs(this.latitude - c.getLatitude()), Math.abs(this.longitude - c.getLongitude()));
    }


    public double getLatintudinalDistance(Coordinate c) {
    SphericCoordinate sc= c.asSphericCoordinate();
	return Math.abs(this.latitude - sc.getLatitude());
    }

    public double getLongitudinalDistance(Coordinate c) {
    SphericCoordinate sc= c.asSphericCoordinate();
	return Math.abs(this.longitude - sc.getLongitude());
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	//if(latitude<0)throw new IllegalArgumentException("latitude<0 not allowed");
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	//if(longitude<0)throw new IllegalArgumentException("longitude<0 not allowed");
	this.longitude = longitude;
    }

    
    
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
		double x = this.erdradius * Math.sin(this.longitude) * Math.cos(this.latitude);
		double y = this.erdradius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double z = this.erdradius * Math.cos(this.longitude);
		
		return new CartesianCoordinate(x,y,z);
		
	}

	@Override
	public boolean isEqual(Coordinate c) {
		return c.asSphericCoordinate().equals(this);
	}

	
	
	
	
	


}
