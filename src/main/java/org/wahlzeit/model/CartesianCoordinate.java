package org.wahlzeit.model;

import java.util.Hashtable;

import org.wahlzeit.Pattern;

import com.googlecode.objectify.annotation.Entity;

/**
 * 
 * @author robin
 *
 */


@Pattern(
		name = "Visitor", 
		participants = { 
				"ConcreteElement" //Teilnehmer=this, siehe accept-Methode 
		}
)
@Entity
public class CartesianCoordinate extends AbstractCoordinate {

	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	private static Hashtable<String, CartesianCoordinate> instances=new Hashtable<String, CartesianCoordinate>();

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * @methodtype constructor
	 */
	private CartesianCoordinate(double x, double y, double z) {
		this.setCartesianCoordinateDataIntern(x, y, z);
		
		this.assertClassInvariants(); 
		// kommt zwar damit redundant 
		//(nicht der Codeinhalt nur der Codeaufruf -> damit unproblematisch)
		//vor, koennte aber sein, dass ich ja mal this.setCar....
		//wegwerfe und dann vergesse this.assertClassInvariants hinzuschreiben. Ist also robuster so.
		
		//naja man kann drueber streiten, pre und post Cond habe ich hier jetzt auch nicht nochmal redundant verwendet
	}
	
	
	public static CartesianCoordinate getInstanceOfMultiton(double x, double y, double z)
	{
		
		String key="x"+x+"y"+y+"z"+z;
		
		
		 CartesianCoordinate result = instances.get(key);
		 
		 if (result == null)
		 {
			 synchronized (CartesianCoordinate.class)
			 {
				 result = instances.get(key);
				 
				 if (result == null)
				 {
					 result = new CartesianCoordinate(x, y, z);
					 instances.put(key, result);
				 }
			 };
		 }
		 
		 return result;
	
	}
	
	


	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * @methodtype set
	 */
	public CartesianCoordinate setCartesianCoordinateData(double x, double y, double z) {
		
		
		assert !Double.isNaN(x);
    	assert !Double.isNaN(y);
    	assert !Double.isNaN(z);
    	
    	if ((Math.abs(Math.sqrt(x * x + y * y + z * z) - this.erdradius)) > this.epsilon) {
			throw new IllegalArgumentException(
					"Die Kartesischen Koordinaten ergeben nicht den Erdradius!");
			// ist auch ein assert und bereits vorhanden, bloss mit
			// spezifizierterem Typ
		}
    	
		
		CartesianCoordinate result=getInstanceOfMultiton(x, y, z);
		
		
		assert result.x==x;
		assert result.y==y;
		assert result.z==z;
		
		result.assertClassInvariants(); 
		
		
		//wird zwar schon ueber konstruktor gecheckt, aber ich habe hier einfach meine alter setter semantik uebernommen,
		//kann ja sein dass mal in einem setter mehr oder weniger erlaubt ist, wie es im konstruktor der fall sein sollte
		
		return result;
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * 
	 * 	helper fuer Constructor
	 * Dies wird einfach nur vom Konstruktor aufgerufen und sonst nicht, da sie sonst die inmutabilitaet zerstoeren wuerde
	 * 
	 */
	private void setCartesianCoordinateDataIntern(double x, double y, double z) {

    	assert !Double.isNaN(x);
    	assert !Double.isNaN(y);
    	assert !Double.isNaN(z);
    	
	
	if ((Math.abs(Math.sqrt(x * x + y * y + z * z) - this.erdradius)) > this.epsilon) {
		throw new IllegalArgumentException(
				"Die Kartesischen Koordinaten ergeben nicht den Erdradius!");
		// ist auch ein assert und bereits vorhanden, bloss mit
		// spezifizierterem Typ
	}

	this.x = x;
	this.y = y;
	this.z = z;
	
	
	//triviale faelle, siehe zur begruendung setter methoden in Speric-Coodrinate
	assert this.x==x;
	assert this.y==y;
	assert this.z==z;

	this.assertClassInvariants();
	

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
	 
	    	super.assertClassInvariants();
	    
	    	
	    	
	    	//verschaerte invarianten!
		assert !Double.isNaN(this.x);
		assert !Double.isNaN(this.y);
		assert !Double.isNaN(this.z);
		
		
		//assert weitere CartesianCoordinate spezifische invarianten
		//da es nicht genau spezifiziert war, wie so eine derartige Klasse auszusehen hat,
		//denke ich reicht das  erst mal
		//aber das prinzip das ich hier anwende wird -denke - ich daraus klar!
		
		
		
	    
	}
	
	
	@Override
	public SphericCoordinate accept(
			DistanceCalculatorVisitor<SphericCoordinate, Void> v,
			Void ein_weiterer_parameter) {
		return v.visit(this, null);
	}
	
	
	//Aehm folgendes macht irgendwie doch keinen Sinn, naja dann mach ichs wohl doch ueber Strings^^
	/*
	private class CartesianCoordinateKey
	{
		double x;
		double y;
		double z;
		
		private CartesianCoordinateKey(double x, double y, double z)
		{
			this.x=x;
			this.y=y;
			this.z=z;
		}
		
		
	}
	*/
	
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		//return this ==obj;//geht so leider nicht, weil ich delta benoetige
		return this.equalsOld(obj);

	}
	
	


	
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
    /********Alter bzw. unrelevanter Code**********/
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
		//return new SphericCoordinate(varLat, varLong);
		return SphericCoordinate.getInstanceOfMultiton(varLat, varLong);

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




	public int hashCodeOld() {
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


	public boolean equalsOld(Object obj) {

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
	
	

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * 
	 * @methodtype set
	 */
	private void setCartesianCoordinateDataOld(double x, double y, double z) {

	    	assert !Double.isNaN(x);
	    	assert !Double.isNaN(y);
	    	assert !Double.isNaN(z);
	    	
		
		if ((Math.abs(Math.sqrt(x * x + y * y + z * z) - this.erdradius)) > this.epsilon) {
			throw new IllegalArgumentException(
					"Die Kartesischen Koordinaten ergeben nicht den Erdradius!");
			// ist auch ein assert und bereits vorhanden, bloss mit
			// spezifizierterem Typ
		}

		this.x = x;
		this.y = y;
		this.z = z;
		
		
		//triviale faelle, siehe zur begruendung setter methoden in Speric-Coodrinate
		assert this.x==x;
		assert this.y==y;
		assert this.z==z;

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
	
	



}
