package org.wahlzeit.model;


/**
 * @author robin
 *
 *schoener waere statt RuntimeException Exception zu nehmen, somit wuerde der Programmierer gezwungen werden immer auf Null zu checken!
 *aber er muesste auch jedesmal dazu try-catch um seinen Code herumbauen, auch wenn er weiss, dass Coordinate nicht null sein kann!
 *von daher habe ich eher eine NullpointerException mit einer hoehren Aussage nachgebaut. Man kann also - wenn man  will - auf eine CoordinateIsNullException catchen
 *
 */
public class CoordinateIsNullException extends RuntimeException
{
//kein inhalt
}
