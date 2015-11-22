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
		//this.setLatitude(varLat);
		//this.setLongitude(varLong);	
	    
        	this.setLatitudeAndLongitude(varLat, varLong);		
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
	 * 
	 * Diese methode ist ein merge von set latitude und set longitude (nachdem ich im testen probleme bekommen habe)
	 * War eigentlich auch klar, da meine Klasseninvariante veletzt wird, wenn ich nur eins setze
	 * 
	 * Die Kommentare in den Auskommentieren Setter-Methoden sind aber ziemlich interessant.... 
	 * solltest dir also mal durchlesen
	 * 
	 * 
	 */
	
	
	public void setLatitudeAndLongitude(double latitude, double longitude) {
		
	    	
		
		if (latitude < 0 || latitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"latitude<0 OR latitude>2PI not allowed");
		
		if (longitude < 0 || longitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"longitude<0 OR longitude>2PI not allowed");
		this.longitude = longitude;	
		this.latitude = latitude;
		
		
		assert this.latitude==latitude;//zwar trivial, aber eine gueltige postcondition
		assert this.longitude==longitude; //zwar trivial, aber eine gueltige postcondition
		//nach dem merge sind noch zwei assertions rausgeflogen, weil die hier keinen sinn mehr machen
		//siehe dazu die auskommentierten Methoden
		
		this.assertClassInvariants();
		
	}
	
	
	
	
/*
	/**
	 * 
	 * @param latitude
	 * 
	 * @methodtype set
	 
	public void setLatitude(double latitude) {
		
	    	double tmp_longitude=this.latitude;
		
		if (latitude < 0 || latitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"latitude<0 OR latitude>2PI not allowed");
		this.latitude = latitude;
		
		assert this.latitude==latitude;//zwar trivial, aber eine gueltige postcondition
		assert this.longitude==tmp_longitude; //auch trivial, weils hier nur ein setter ist, aber ich denke das verdeutlicht 
		//schon ziemlich gut die arbeitsweise mit den ganzen post und pre conditions
		//Auserdem haette es sein koennen, dass longitude durch einen nicht gewuenschten nebeneffekt geandert worden waere
		this.assertClassInvariants();
		
	}
	
	/**
	 * 
	 * @param longitude
	 * 
	 * @methodtype set
	 
	public void setLongitude(double longitude) {
		
	    	double tmp_latitude=this.latitude;
	    
		if (longitude < 0 || longitude > (Math.PI * 2))
			throw new IllegalArgumentException(
					"longitude<0 OR longitude>2PI not allowed");
		this.longitude = longitude;
		
		
		assert this.longitude==longitude;//zwar trivial, aber eine gueltige postcondition
		assert this.latitude==tmp_latitude; //auch trivial, weils hier nur ein setter ist, aber ich denke das verdeutlicht 
		//schon ziemlich gut die arbeitsweise mit den ganzen post und pre conditions
		//Auserdem haette es sein koennen, dass latitude durch einen nicht gewuenschten nebeneffekt geandert worden waere
		this.assertClassInvariants();
		
	}
	
*/	
	
	
	

	/**
	 * 
	 * @return
	 * 
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
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
	    	super.assertClassInvariants();
	    
	    	
	    	//verschaerte invarianten!:
	
		assert !Double.isNaN(this.longitude);
		assert !Double.isNaN(this.latitude);
		
		//folgendes wird zwar schon in den settern abgecheckt, koennte aber ja passieren, dass irgendwo anders auch 
		//der zustand geaendert worden waere und dann ein check der klassenvarianten stattfindet
		assert this.longitude<= Math.PI && this.longitude>= 0;//hab ich jetzt halt so definiert
		assert this.longitude<= Math.PI && this.latitude>= 0;//hab ich jetzt halt so definiert
		
		//assert weitere SphericCoordinate spezifische invarianten
		//da es nicht genau spezifiziert war, wie so eine derartige Klasse auszusehen hat,
		//denke ich reicht das  erst mal
		//aber das prinzip das ich hier anwende wird -denke - ich daraus klar!
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
