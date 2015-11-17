package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * 
 * @author robin
 *
 */



@Entity
public class CartesianCoordinate extends AbstractCoordinate {

	private double x = 0;
	private double y = 0;
	private double z = 0;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.setCartesianCoordinateData(x, y, z);
		
		this.assertClassInvariants(); 
		// kommt zwar damit redundant 
		//(nicht der Codeinhalt nur der Codeaufruf -> damit unproblematisch)
		//vor, koennte aber sein, dass ich ja mal this.setCar....
		//wegwerfe und dann vergesse this.assertClassInvariants hinzuschreiben. Ist also robuster so.
		
		//naja man kann drueber streiten, pre und post Cond habe ich hier jetzt auch nicht nochmal redundant verwendet
	}
	


	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * @methodtype set
	 */
	public void setCartesianCoordinateData(double x, double y, double z) {

		//TODO preConditions
		
		if ((Math.abs(Math.sqrt(x * x + y * y + z * z) - this.erdradius)) > this.epsilon) {
			throw new IllegalArgumentException(
					"Die Kartesischen Koordinaten ergeben nicht den Erdradius!");
			// ist auch ein assert und bereits vorhanden, bloss mit
			// spezifizierterem Typ
		}

		this.x = x;
		this.y = y;
		this.z = z;

		
		
		//TODO postconditions
		this.assertClassInvariants();
		
		
		
		/*
		 * //folgendes sehe ich ziemlich kritisch, da ich hier diese Klasse noch
		 * staerker an die Spherische Klasse binde! //normalerweise will man das
		 * ganze in einen eigenen Service auslagern! //Ausserdem benoete ich
		 * eine Ausnahmeimplementierung, falls die andere Klasse genau das
		 * gleiche vorhat //also ein Art Endlos-Rekursions-Brecher try {
		 * this.asSphericCoordinate(Rekursions-Breaker=TRUE).
		 * asCartesianCoordinate(Rekursions-Breaker=TRUE); }
		 * catch(IllegalArgumentException e) { throw new
		 * IllegalArgumentException(
		 * "Die Kartesischen muessen wohl falsch sein, da Sie sich nicht in Spherische konvertieren lassen und vice versa"
		 * ); }
		 */
	}

		
	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

	
	//liefert Abstrakten Zustand
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
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
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate c) {

		/**
		 * folgendes auskommentierte waere doch auch ne schoene lsgn^^ oder was
		 * meint ihr dazu?
		 */
		// SphericCoordinate sc = this.asSphericCoordinate();
		// return sc.getDistance(c);

		CartesianCoordinate cc = c.asCartesianCoordinate();

		return Math.sqrt((this.x - cc.x) * (this.x - cc.x) + (this.y - cc.y)
				* (this.y - cc.y) + (this.z - cc.z) * (this.z - cc.z));

	}

	
	
	
	
	
	@Override
	public boolean isEqual(Coordinate c) {
		return c.asCartesianCoordinate().equals(this);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {

		double varLat = this.calcLongitude(); // Math.atan2(this.y, this.x);
		// //macht eigentlich das selbe,
		// aber egal, jetzt hab ichs schon
		// abgetippt^^
		double varLong = Math.PI
				/ 2
				- Math.atan(this.z
						/ Math.sqrt(this.x * this.x + this.y * this.y));
		return new SphericCoordinate(varLat, varLong);

		/*
		 * double varLat=Math.atan(this.y/this.x);//this.calcLongitude(); double
		 * varLong =Math.acos(this.z/(this.x*this.x + this.y*this.y +
		 * this.z*this.z)); //double varLong = Math.atan(Math.sqrt(this.x*this.x
		 * + this.y* this.y) / this.z); return new SphericCoordinate(varLat,
		 * varLong);
		 */

	}
	
	

	/**
	 * 
	 * @return
	 * @methodtype helper
	 * 
	 *             Kurzschlusslogik mit return, von daher in helper
	 *             ausgelagert^^
	 */
	private double calcLongitude() {
		if (x > 0) {
			return Math.atan(this.y / this.x);
		}

		if (x == 0) {
			return Math.signum(this.y) * Math.PI / 2;
		}

		if (this.x < 0 && this.y >= 0) {
			return Math.atan(this.y / this.x) + Math.PI;
		}

		if (this.x < 0 && this.y < 0) {
			return Math.atan(this.y / this.x) - Math.PI;
		}

		throw new RuntimeException(
				"Irgendwas ist mathematisch richtig inkorrekt");

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

		if (Math.abs(this.x - other.x) > this.epsilon)
			return false;
		if (Math.abs(this.y - other.y) > this.epsilon)
			return false;
		if (Math.abs(this.z - other.z) > this.epsilon)
			return false;

		/*
		 * if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
		 * return false; if (Double.doubleToLongBits(y) !=
		 * Double.doubleToLongBits(other.y)) return false; if
		 * (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
		 * return false;
		 */
		return true;
	}

	@Override
	public SphericCoordinate accept(
			DistanceCalculatorVisitor<SphericCoordinate, Void> v,
			Void ein_weiterer_parameter) {
		return v.visit(this, null);
	}

}
