package org.wahlzeit.model;

/**
 * @author robin
 * 
 *         Ein Interface, das sowohl von Coordinate und NullCoordinate
 *         implementiert wird, um damit beiden das gleiche
 *         Schnittstellenverhalten zu geben, damit polymorphes internes
 *         Verhalten ermoeglicht wird!
 *
 */
public interface AbstractCoordinate {
    /**
     * @param
     * @return
     * 
     * 	calculate the distance seperatly of latitude and longitude and
     *         return the result packed into a {@link AbstractCoordinate} Object
     * 
     */
    public AbstractCoordinate getDistance(AbstractCoordinate c);

    /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LatitudinalDistance and the
     *         parmam c
     */
    public double getLatintudinalDistance(AbstractCoordinate c);

    /**
     * @param c
     * @return
     * 
     * 	calculate the absolute Difference of LongitudinallDistance and
     *         the parmam c
     * 
     */
    public double getLongitudinalDistance(AbstractCoordinate c);

    /**
     * @return
     * 
     * 	getter
     */
    public double getLatitude();

    /**
     * @param latitude
     * 
     * setter
     */
    public void setLatitude(double latitude);

    /**
     * @return
     * 
     * 	getter
     */
    public double getLongitude();

    /**
     * @param longitude
     * 
     * setter
     */
    public void setLongitude(double longitude);
}
