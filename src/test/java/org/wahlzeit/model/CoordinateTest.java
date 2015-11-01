package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class CoordinateTest {

    private ArrayList<AbstractCoordinate> c = new ArrayList<AbstractCoordinate>();
    private double delta = 0.00001;

    @Before
    public void initPhotoFilter() {
	c.clear();
	for (int i = 0; i < 5; i++) {
	    c.add(new Coordinate(i * 3, i * 7));// 0-4
	}

	c.add(new NullCoordinate());// 5
	c.add(new NullCoordinate());// 6

	c.add(new Coordinate(10, 20));// 7
	c.add(new Coordinate(0, 30));// 8
	c.add(new Coordinate(30, 0));// 9

	c.add(new Coordinate(678.77, 77.8723));// 10
	c.add(new Coordinate(5, 5));// 11
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
	assertNotNull(c.get(7));

	// Check properties after creation
	assertEquals(10, c.get(7).getLatitude(), delta);
	assertEquals(20, c.get(7).getLongitude(), delta);
    }

    /**
     *
     */
    @Test
    public void testLatitudeDistanceCalculator() {
	assertEquals(668.77, c.get(7).getLatintudinalDistance(c.get(10)), delta);
	assertEquals(30, c.get(8).getLatintudinalDistance(c.get(9)), delta);

    }

    @Test
    public void testLongitudinalDistanceCalculator() {
	assertEquals(15, c.get(7).getLongitudinalDistance(c.get(11)), delta);
	assertEquals(57.8723, c.get(7).getLongitudinalDistance(c.get(10)), delta);

    }

    @Test
    public void testequalObjects() {
	for (int i = 0; i < c.size(); i++) {
	    if (c.get(i) instanceof Coordinate) {
		assertEquals(0, c.get(i).getLongitudinalDistance(c.get(i)), delta);
		assertEquals(0, c.get(i).getLatintudinalDistance(c.get(i)), delta);
	    }
	}

    }

    @Test
    public void testMethodGetDistance() {

	//Coordinate c_tmp1 = new Coordinate(5, 15);
	//Coordinate c_tmp2 = new Coordinate(5, 25);

	// assertEquals(c_tmp1.hashCode(),
	// c.get(7).getDistance(c.get(11)).hashCode());
	// assertEquals(c_tmp2, c.get(8).getDistance(c.get(11)));

	assertEquals(0.7919053815323334, c.get(7).getDistance(c.get(11)), delta);
	assertEquals(1.2857866311189428, c.get(8).getDistance(c.get(11)), delta);
	
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetLatitude() {

	c.get(7).setLatitude(-10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodsetLongitude() {

	c.get(7).setLongitude(-5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructorAccess1() {

	new Coordinate(-1, 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructorAccess2() {

	new Coordinate(10, -1);

    }

    // folgende Faelle sind eigentlich trivial, aber testen macht spass^^

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate1() {

	c.get(5).getDistance(c.get(7));

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate2() {

	c.get(5).getLatintudinalDistance(c.get(7));

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate3() {

	c.get(5).getLatitude();

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate4() {

	c.get(5).getLongitude();

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate5() {

	c.get(5).getLongitudinalDistance(c.get(7));

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate6() {

	c.get(5).setLatitude(5);

    }

    @Test(expected = CoordinateIsNullException.class)
    public void testCorrectNullCoordinate7() {

	c.get(5).setLongitude(5);

    }

}
