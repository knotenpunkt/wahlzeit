package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import com.googlecode.objectify.annotation.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

/**
 * 
 * @author Robin
 * 
 *         Eigentlich ist diese Klasse auf meiner alten Coordinate Klasse
 *         enstanden Auch in dieser hatte ich bereits ein interface/abstrakte
 *         klasse und eine Nullcoordinate-Klasse
 * 
 *         Jetzt hab ich diesen Test auf die neue Schnittstelle angepasst, aber
 *         noch nicht die Kartesische Koordinate hinzugefuegt!
 * 
 *         Dafuer schreib ich eine weitere Testklasse und zwar eine Allgemeine,
 *         die genau das "allgemeine" Verhalten von Coordinate testen soll!!!!
 *
 */
@Entity
public class SphericCoordinateTest {

    private ArrayList<Coordinate> c = new ArrayList<Coordinate>();
    private double delta = 0.00001;

    @Before
    public void initCoordinate() {
	c.clear();
	for (int i = 0; i < 5; i++) {
	    c.add(SphericCoordinate.getInstanceOfMultiton(i * 0.3, i * 0.7));// 0-4
	}

	c.add(NullCoordinate.getInstance());// 5
	c.add(NullCoordinate.getInstance());// 6

	c.add(SphericCoordinate.getInstanceOfMultiton(0.10, 0.20));// 7
	c.add(SphericCoordinate.getInstanceOfMultiton(0, 0.30));// 8
	c.add(SphericCoordinate.getInstanceOfMultiton(0.30, 0));// 9

	c.add(SphericCoordinate.getInstanceOfMultiton(0.67877, 0.778723));// 10
	c.add(SphericCoordinate.getInstanceOfMultiton(0.5, 0.5));// 11
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
	assertNotNull(c.get(7));

	// Check properties after creation
	assertEquals(0.10, c.get(7).asSphericCoordinate().getLatitude(), delta);
	assertEquals(0.20, c.get(7).asSphericCoordinate().getLongitude(), delta);
    }

    /**
     *
     */
    @Test
    public void testLatitudeDistanceCalculator() {
	assertEquals(0.57877, c.get(7).asSphericCoordinate().getLatintudinalDistance(c.get(10)), delta);
	assertEquals(0.30, c.get(8).asSphericCoordinate().getLatintudinalDistance(c.get(9)), delta);

    }

    @Test
    public void testLongitudinalDistanceCalculator() {
	assertEquals(0.3, c.get(7).asSphericCoordinate().getLongitudinalDistance(c.get(11)), delta);
	assertEquals(0.578723, c.get(7).asSphericCoordinate().getLongitudinalDistance(c.get(10)), delta);

    }

    @Test
    public void testequalObjects() {
	for (int i = 0; i < c.size(); i++) {
	    if (c.get(i) instanceof SphericCoordinate) {
		assertEquals(0, c.get(i).asSphericCoordinate().getLongitudinalDistance(c.get(i)), delta);
		assertEquals(0, c.get(i).asSphericCoordinate().getLatintudinalDistance(c.get(i)), delta);
	    }
	}

    }

    @Test
    public void testMethodGetDistance() {

	// Coordinate c_tmp1 = new Coordinate(5, 15);
	// Coordinate c_tmp2 = new Coordinate(5, 25);

	// assertEquals(c_tmp1.hashCode(),
	// c.get(7).getDistance(c.get(11)).hashCode());
	// assertEquals(c_tmp2, c.get(8).getDistance(c.get(11)));

	assertEquals(0.4905775700578932, c.get(7).getDistance(c.get(11)), delta);
	assertEquals(0.5353515564625099, c.get(8).getDistance(c.get(11)), delta);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetLatitudeAndLongitude1() {

	c.get(7).asSphericCoordinate().setLatitudeAndLongitude(-10, 10);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetLatitudeAndLongitude2() {

	c.get(7).asSphericCoordinate().setLatitudeAndLongitude(10, -10);

    }
   

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructorAccess1() {

    	SphericCoordinate.getInstanceOfMultiton(-1, 0.10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructorAccess2() {

    	SphericCoordinate.getInstanceOfMultiton(0.10, -1);

    }

    // folgende Faelle sind eigentlich trivial, aber testen macht spass^^

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate1() {

	c.get(5).getDistance(c.get(7));

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate2() {

	c.get(5).asSphericCoordinate().getLatintudinalDistance(c.get(7));

    }

    // folgende tests passen nicht mehr auf die neue client-schnittstelle
    // eine zweite client-schnittstelle einzufuehren kam mir dann doch zu
    // unsinnig vor, von daher fliegen folgende testcases raus
    // und ich lasse nur noch aus historischen und nachvollziehbaren gruenden
    // die tests als kommentar hier drinnen stehen

    /*
     * @Test(expected = CoordinateIsNullException.class) public void
     * testCorrectNullCoordinate3() {
     * 
     * c.get(5).getLatitude();
     * 
     * }
     * 
     * @Test(expected = CoordinateIsNullException.class) public void
     * testCorrectNullCoordinate4() {
     * 
     * c.get(5).getLongitude();
     * 
     * }
     * 
     * @Test(expected = CoordinateIsNullException.class) public void
     * testCorrectNullCoordinate5() {
     * 
     * c.get(5).getLongitudinalDistance(c.get(7));
     * 
     * }
     * 
     * @Test(expected = CoordinateIsNullException.class) public void
     * testCorrectNullCoordinate6() {
     * 
     * c.get(5).setLatitude(5);
     * 
     * }
     * 
     * @Test(expected = CoordinateIsNullException.class) public void
     * testCorrectNullCoordinate7() {
     * 
     * c.get(5).setLongitude(5);
     * 
     * }
     */
}
