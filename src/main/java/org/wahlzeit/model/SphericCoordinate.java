package org.wahlzeit.model;

/**
 * @author robin
 *
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude = 0;
	private double longitude = 0;

	/**
	 * 
	 * 
	 * @param varLat
	 * @param varLong
	 * 
	 * @methodtype constructor
	 * 
	 */
	public SphericCoordinate(double varLat, double varLong) {
		this.setLatitude(varLat);
		this.setLongitude(varLong);
		
		
		
		this.assertClassInvariants();//siehe begruendung cartesiancoordinate
		
	}
	
	
	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 * 
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		
		//TODO weitere preconditions
		
		if (latitude < 0 || latitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"latitude<0 OR latitude>2PI not allowed");
		this.latitude = latitude;
		
		//TODO postconditions
		this.assertClassInvariants();
		
	}

	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 * 
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		
		//TODO weitere preconditions
		
		if (longitude < 0 || longitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"longitude<0 OR longitude>2PI not allowed");
		this.longitude = longitude;
		
		
		//TODO postconditions
		this.assertClassInvariants();
		
	}
	
	
	//liefert Abstrakten Zustand
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
		

		double x = this.erdradius * Math.sin(this.longitude)
				* Math.cos(this.latitude);
		double y = this.erdradius * Math.sin(this.longitude)
				* Math.sin(this.latitude);
		double z = this.erdradius * Math.cos(this.longitude);

		return new CartesianCoordinate(x, y, z);//hier drinnen werden assertions gecheckt

	}
	
	@Override
	protected void assertClassInvariants()
	{
		//TODO
	}
	
		
	
	/********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/	
	
	

	/**
	 * 
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate c) {

		SphericCoordinate sc = c.asSphericCoordinate();

		return Math.acos(Math.sin(this.latitude) * Math.sin(sc.getLatitude())
				+ Math.cos(this.latitude) * Math.cos(sc.getLatitude())
				* Math.cos(Math.abs(sc.getLongitude() - this.longitude)));
		// return new Coordinate(Math.abs(this.latitude - c.getLatitude()),
		// Math.abs(this.longitude - c.getLongitude()));
	}

	public double getLatintudinalDistance(Coordinate c) {
		SphericCoordinate sc = c.asSphericCoordinate();
		return Math.abs(this.latitude - sc.getLatitude());
	}

	public double getLongitudinalDistance(Coordinate c) {
		SphericCoordinate sc = c.asSphericCoordinate();
		return Math.abs(this.longitude - sc.getLongitude());
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

		if (Math.abs(this.latitude - other.latitude) > this.epsilon)
			return false;
		if (Math.abs(this.longitude - other.longitude) > this.epsilon)
			return false;

		/*
		 * if (Double.doubleToLongBits(latitude) != Double
		 * .doubleToLongBits(other.latitude)) return false; if
		 * (Double.doubleToLongBits(longitude) != Double
		 * .doubleToLongBits(other.longitude)) return false;
		 */
		return true;

	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	

	@Override
	public boolean isEqual(Coordinate c) {
		return c.asSphericCoordinate().equals(this);
	}

	@Override
	public SphericCoordinate accept(
			DistanceCalculatorVisitor<SphericCoordinate, Void> v,
			Void ein_weiterer_parameter) {
		return v.visit(this, null);
	}

}
