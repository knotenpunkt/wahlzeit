package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.mockito.internal.stubbing.answers.ThrowsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

/**
 * 
 * @author Robin
 * 
 *         HINWEIS: siehe als Ergaenzung bitte auch die Klasse
 *         SphericCoordinateTest
 *
 */
public class CoordinateTest {

    private Coordinate c1;
    private Coordinate c2;

    private Coordinate c3;
    private Coordinate c4;

    private Coordinate c5;

    private double delta = 0.00001;

    @Before
    public void initCoordinate() {
	this.c1 = new SphericCoordinate(Math.toRadians(49.55), Math.toRadians(11.0036));// (22.0,
											// 23.0);
	this.c2 = new CartesianCoordinate(3133.482676255299, 4880.110125072319, -2654.1845234976745);
	this.c3 = new SphericCoordinate(Math.toRadians(70.0), Math.toRadians(80.0));
	this.c4 = new CartesianCoordinate(4509.9270504078, 4509.9270504078, 3.905398642480909E-13);
	this.c5 = new NullCoordinate();
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
	assertNotNull(c1);
	assertNotNull(c2);
	assertNotNull(c5);

	// Check properties after creation
	assertEquals(Math.toRadians(49.55), (((SphericCoordinate) c1).getLatitude()), delta);
	assertEquals(Math.toRadians(11.0036), (((SphericCoordinate) c1).getLongitude()), delta);

	assertEquals(3133.482676255299, (((CartesianCoordinate) c2).getX()), delta);
	assertEquals(4880.110125072319, (((CartesianCoordinate) c2).getY()), delta);
	assertEquals(-2654.1845234976745, (((CartesianCoordinate) c2).getZ()), delta);

    }

    /**
     *
     */
    @Test
    public void testMethodIsEqual() {
	/*
	 * //System.out.println(Math.toDegrees(Math.toRadians(55)));
	 * 
	 * CartesianCoordinate cccc=new SphericCoordinate(Math.toRadians(45),
	 * Math.toRadians(90)).asCartesianCoordinate(); CartesianCoordinate
	 * kkkk=c4.asSphericCoordinate().asCartesianCoordinate();
	 * CartesianCoordinate dbgpoint= c1.asCartesianCoordinate();
	 * SphericCoordinate dbgpoint2=dbgpoint.asSphericCoordinate();
	 * System.out.println(((SphericCoordinate)c1).getLongitude());
	 * System.out.println(((SphericCoordinate)c1).getLatitude());
	 * 
	 * System.out.println(Math.sqrt(dbgpoint.getX()*dbgpoint.getX() +
	 * dbgpoint.getY()*dbgpoint.getY() + dbgpoint.getZ()*dbgpoint.getZ()));
	 * 
	 * System.out.println("dbg-point");
	 */

	// new SphericCoordinate(Math.toRadians(-180), Math.toRadians(-180));

	assertTrue(c1.isEqual(c1.asCartesianCoordinate()));
	assertTrue(c2.isEqual(c2.asCartesianCoordinate()));
	assertTrue(c3.isEqual(c3.asSphericCoordinate()));
	assertTrue(c4.isEqual(c4.asSphericCoordinate()));
    }

    @Test
    public void testMethodIsEqualHa06() {

	assertTrue(c1.isEqualHa06(c1.asCartesianCoordinate()));
	assertTrue(c2.isEqualHa06(c2.asCartesianCoordinate()));
	assertTrue(c3.isEqualHa06(c3.asSphericCoordinate()));
	assertTrue(c4.isEqualHa06(c4.asSphericCoordinate()));
    }

    @Test
    public void testMethodGetDistance() {

	assertEquals(0, c1.getDistance(c1), this.delta);
	assertEquals(0, c2.getDistance(c2), this.delta);
	assertEquals(0, c3.getDistance(c3), this.delta);
	assertEquals(0, c4.getDistance(c4), this.delta);

	assertEquals(0, c1.getDistance(c1.asCartesianCoordinate()), this.delta);
	assertEquals(0, c2.getDistance(c2.asSphericCoordinate()), this.delta);

    }

    @Test
    public void testMethodGetDistanceHa06() {

	assertEquals(0, c1.getDistanceHa06(c1), this.delta);
	assertEquals(0, c2.getDistanceHa06(c2), this.delta);
	assertEquals(0, c3.getDistanceHa06(c3), this.delta);
	assertEquals(0, c4.getDistanceHa06(c4), this.delta);

	assertEquals(0, c1.getDistanceHa06(c1.asCartesianCoordinate()), this.delta);
	assertEquals(0, c2.getDistanceHa06(c2.asSphericCoordinate()), this.delta);

    }

    @Test
    public void testNullCoordinateIsEqualsMethod() {
	assertTrue(!(c5.isEqual(c5)));
	// assertTrue(!(c1.isEqual(c5)));//geht so nicht muesste sonst in jeder
	// Methode von isEqual ein instanceof stehen
	// von daher nehme ich hier ein throw exception in kauf

	boolean flag = false;
	try {
	    c1.isEqual(c5);
	} catch (Throwable e) {
	    flag = true;
	}

	assertTrue(flag);

	assertTrue(!(c5.isEqual(c1)));
    }

    @Test
    public void testCorrectConversion() {
	assertEquals(((SphericCoordinate) c1).getLatitude(),
		c1.asCartesianCoordinate().asSphericCoordinate().getLatitude(), delta);
	assertEquals(((SphericCoordinate) c1).getLongitude(),
		c1.asCartesianCoordinate().asSphericCoordinate().getLongitude(), delta);

	assertEquals(((CartesianCoordinate) c2).getX(), c2.asSphericCoordinate().asCartesianCoordinate().getX(), delta);
	assertEquals(((CartesianCoordinate) c2).getY(), c2.asSphericCoordinate().asCartesianCoordinate().getY(), delta);
	assertEquals(((CartesianCoordinate) c2).getZ(), c2.asSphericCoordinate().asCartesianCoordinate().getZ(), delta);

    }

    @Test
    public void testDistanceCaluclatorService() {

	DistanceCalculatorService distanceCalculatorService = new DistanceCalculatorService();
	distanceCalculatorService.execute(c1, c1.asCartesianCoordinate());
	assertEquals(0, distanceCalculatorService.getResult(), this.delta);

	distanceCalculatorService.execute(c2, c2.asCartesianCoordinate());
	assertEquals(0, distanceCalculatorService.getResult(), this.delta);

	distanceCalculatorService.execute(c3, c3.asSphericCoordinate());
	assertEquals(0, distanceCalculatorService.getResult(), this.delta);

	distanceCalculatorService.execute(c4, c4.asSphericCoordinate());
	assertEquals(0, distanceCalculatorService.getResult(), this.delta);

    }

    // schoener ware es wenn ichs wie in der anderen Tesetklasse von mir auf
    // einzelene methoden aufteilen wuerde
    // da man dann gleich weis, was genau faild, hiermit weis ich nur dass die
    // familie failt, den genauen fehler muss man dann noch lokalisieren
    // ich wollte einfach mal so einen Test schreiben, von daher hab ich des mal
    // so gemacht^^
    @Test(expected = RuntimeException.class)
    public void testPossibleExceptions() {

	int counter = 0;

	try {
	    c5.asCartesianCoordinate();
	} catch (Throwable e) {
	    counter++;
	}
	try {
	    c5.asSphericCoordinate();
	} catch (Throwable e) {
	    counter++;
	}

	try {
	    c5.getDistance(c1);
	} catch (Throwable e) {
	    counter++;
	}
	try {
	    c1.getDistance(c5);
	} catch (Throwable e) {
	    counter++;
	}

	if (counter == 4) {
	    throw new RuntimeException("ExceptionTests fails");
	}

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalContructorParameter() {
	new CartesianCoordinate(5, 9, 15);
    }
    
 
    
    @Test(expected = AssertionError.class)
    public void testIllegalClassInvariants1() {
	new CartesianCoordinate(Double.NaN, 9, 15);
    }
    
    @Test(expected = AssertionError.class)
    public void testIllegalClassInvariants2() {
	new CartesianCoordinate(0, Double.NaN, 15);
    }
    
    @Test(expected = AssertionError.class)
    public void testIllegalClassInvariants3() {
	new CartesianCoordinate(0, 9, Double.NaN);
    }
    
    
    //die anderen Klasseninvarianten werden schon indirekt ueberprueft, bzw. getestet
    //an manche klasseninvarianten komme ich auch nicht direkt, da pre/postconditions diese schon abfangen
    //ums also noch besser zu machen, muesste man eine fehlerhafte Klasse schreiben, die von AbstractCoordinate erbt
    //und somit koennte ich zumindesten den abstrakten Zustand bzw. dessen Klasseninvarianz testen^^
    
    

}
