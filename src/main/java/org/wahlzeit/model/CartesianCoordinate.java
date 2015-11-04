package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class CartesianCoordinate extends AbstractCoordinate {

	private double x=0;
	private double y=0;
	private double z=0;
	
		
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public double getDistance(Coordinate c) {
		
		
		
		/**
		 * folgendes auskommentierte waere doch auch ne schoene lsgn^^
		 * oder was meint ihr dazu?
		 */
		//SphericCoordinate sc = this.asSphericCoordinate();
		//return sc.getDistance(c);
		
		CartesianCoordinate cc=c.asCartesianCoordinate();
		
		return Math.sqrt( (this.x-cc.x)*(this.x-cc.x) + (this.y-cc.y)*(this.y-cc.y) + (this.z-cc.z)*(this.z-cc.z));
		
		
	}

	
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		return c.asCartesianCoordinate().equals(this);	
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		
		/*
		double varLat=Math.atan2(this.y, this.x);//this.calcLongitude();
		double varLong =Math.PI/2- Math.atan(this.z/Math.sqrt(this.x*this.x+this.y*this.y));		
		return new SphericCoordinate(varLat, varLong);
		*/
		
		double varLat=Math.atan(this.y/this.x);//this.calcLongitude();
		double varLong =Math.acos(this.z/(this.x*this.x + this.y*this.y + this.z*this.z));		
		return new SphericCoordinate(varLat, varLong);
		
		
	}
	
	/**
	 * 
	 * @return
	 * @methodtype helper
	 * 
	 * Kurzschlusslogik mit return, von daher in helper ausgelagert^^
	 */
	private double calcLongitude()
	{
		if(x>0)
		{
			return Math.atan(this.y/this.x);
		}
		
		if(x==0)
		{
			return Math.signum(this.y)*Math.PI/2;
		}
		
		if(this.x < 0 && this.y >= 0)
		{
			return Math.atan(this.y/this.x) + Math.PI;
		}
		
		if(this.x < 0 && this.y < 0)
		{
			return Math.atan(this.y/this.x) - Math.PI;
		}
		
		throw new RuntimeException("Irgendwas ist mathematisch richtig inkorrekt");
		
		
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate()
	{
		return this;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
	
	
	
	

}
