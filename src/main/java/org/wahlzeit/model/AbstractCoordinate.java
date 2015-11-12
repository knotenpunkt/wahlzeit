package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

/**
 * @author robin
 * 
 */

// @Subclass(name = "AbstractCoordinate")
abstract class AbstractCoordinate implements Coordinate {

    protected final int erdradius = 6378;
    protected final double epsilon = 0.00001;

    @Override
    public double getDistanceHa06(Coordinate c) {
	// ich finde ob ich jetzt auf dem Objekt CartesianCoordinate oder auf
	// getX, getY, getZ arbeite
	// macht keinen unterschied
	// asCartesianCoordinate hat unteranderem den Vorteil, dass ich das
	// ganze zusammenhaengend bekomme
	// Bei meiner letzten Abgabe wurde ja hauptsaechlich kritisiert, dass
	// asCartesian und asSpheric gleichzeitig verwendet habe
	// Dies faellt mit dieser Abgabe ja jetzt raus

	CartesianCoordinate dhis = this.asCartesianCoordinate();
	CartesianCoordinate cc = c.asCartesianCoordinate();

	return Math.sqrt((dhis.getX() - cc.getX()) * (dhis.getX() - cc.getX())
		+ (dhis.getY() - cc.getY()) * (dhis.getY() - cc.getY())
		+ (dhis.getZ() - cc.getZ()) * (dhis.getZ() - cc.getZ()));

    }

    /**
     * 
     * @param c
     * @return
     * 
     * @methodtype comparsion
     */
    public boolean isEqualHa06(Coordinate c) {
	if (c == this) // this entspricht dem dynamischen typ, die operationen
		       // auf this aber dem statischen,
		       // also hoechstens AbstractCoordinate
		       // ist aber eigentlich hier wurschd, da eh nur die
		       // zeigerwerte und nich die derefernzierten werte
		       // verglichen werden^^
		       // Die Hausaufgabe war diesmal so wenig, also musste ich
		       // irgend nen Text dazu schreiben^^

	    if (c == null)
		return false;

	CartesianCoordinate dhis = this.asCartesianCoordinate();
	CartesianCoordinate cc = c.asCartesianCoordinate();

	// if (c instanceof Coordinate)//wurde nur benoetigt werden, wenn oben
	// object zugelassen waere
	// return false;

	CartesianCoordinate other = c.asCartesianCoordinate();

	if (Math.abs(dhis.getX() - other.getX()) > this.epsilon)
	    return false;
	if (Math.abs(dhis.getY() - other.getY()) > this.epsilon)
	    return false;
	if (Math.abs(dhis.getZ() - other.getZ()) > this.epsilon)
	    return false;

	return true;

    }

    /*
     * 
     * ********Text noch von Aufgabe 1 fuer folgenden auskommentierten
     * Code:*************
     * 
     * Ein Interface (nach dem refactoring jetzt eine Abstrakte Klasse), das
     * sowohl von Coordinate und NullCoordinate implementiert wird, um damit
     * beiden das gleiche Schnittstellenverhalten zu geben, damit polymorphes
     * internes Verhalten ermoeglicht wird!
     *
     */

    /*
     * /**
     * 
     * @param
     * 
     * @return
     * 
     * calculate the distance seperatly of latitude and longitude and return the
     * result packed into a {@link AbstractCoordinate} Object
     * 
     */
    // public abstract double getDistance(AbstractCoordinate c);
    // public abstract boolean isEqual(Coordinate c);

    /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LatitudinalDistance and the
     *         parmam c
     *
     *         public abstract double getLatintudinalDistance(AbstractCoordinate
     *         c);
     * 
     *         /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LongitudinallDistance and
     *         the parmam c
     * 
     *
     *         public abstract double getLongitudinalDistance(AbstractCoordinate
     *         c);
     * 
     *         /**
     * @return
     * 
     * 	getter
     *
     *         public abstract double getLatitude();
     * 
     *         /**
     * @param latitude
     * 
     *            setter
     *
     *            public abstract void setLatitude(double latitude);
     * 
     *            /**
     * @return
     * 
     * 	getter
     *
     *         public abstract double getLongitude();
     * 
     *         /**
     * @param longitude
     * 
     *            setter
     *
     *            public abstract void setLongitude(double longitude);
     */
}
