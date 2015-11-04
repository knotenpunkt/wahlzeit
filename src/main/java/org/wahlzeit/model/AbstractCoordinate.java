package org.wahlzeit.model;

/**
 * @author robin
 * 
 * 
 * 		********Text noch von Aufgabe 1:*************
 * 
 *         Ein Interface (nach dem refactoring jetzt eine Abstrakte Klasse), das sowohl von Coordinate und NullCoordinate
 *         implementiert wird, um damit beiden das gleiche
 *         Schnittstellenverhalten zu geben, damit polymorphes internes
 *         Verhalten ermoeglicht wird!
 *
 */
abstract class AbstractCoordinate implements Coordinate {
   
	
	protected final int erdradius= 6378;
	
	/*
	/**
     * @param
     * @return
     * 
     * 	calculate the distance seperatly of latitude and longitude and
     *         return the result packed into a {@link AbstractCoordinate} Object
     * 
     */
//    public abstract double getDistance(AbstractCoordinate c);    
 //   public abstract boolean isEqual(Coordinate c);
    

    /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LatitudinalDistance and the
     *         parmam c
     *
    public abstract double getLatintudinalDistance(AbstractCoordinate c);

    /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LongitudinallDistance and
     *         the parmam c
     * 
     *
    public abstract double getLongitudinalDistance(AbstractCoordinate c);

    /**
     * @return
     * 
     * 	getter
     *
    public abstract double getLatitude();

    /**
     * @param latitude
     * 
     * setter
     *
    public abstract void setLatitude(double latitude);

    /**
     * @return
     * 
     * 	getter
     *
    public abstract double getLongitude();

    /**
     * @param longitude
     * 
     * setter
     *
    public abstract void setLongitude(double longitude);
    */
}
