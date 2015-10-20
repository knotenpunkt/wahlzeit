package org.wahlzeit.model;


public class PhotoCoordinate implements Coordinate 
{
	
	private double latitude=0;
	private double longitude=0;
	
	public  PhotoCoordinate(double lat, double longi)
	{
		this.latitude=lat;
		this.longitude=longi;
	}

	@Override
	public Coordinate getDistance(Coordinate c)
	{
		return new PhotoCoordinate(Math.abs(this.latitude-c.getLatitude()),Math.abs(this.longitude-c.getLongitude()));
	}

	@Override
	public double getLatintudinalDistance(Coordinate c)
	{
		return Math.abs(this.latitude-c.getLatitude());
	}

	@Override
	public double getLongitudinalDistance(Coordinate c)
	{
		return Math.abs(this.longitude-c.getLongitude());
	}
	
	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}


}
