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
 * HINWEIS: siehe als Ergaenzung bitte auch die Klasse SphericCoordinateTest
 *
 */
public class CoordinateTest  {

    private Coordinate c1;
    private Coordinate c2; 
    
    private Coordinate c3;
    private Coordinate c4; 
    
    private Coordinate c5;
    
    private double delta = 0.00001;

    @Before
    public void initCoordinate() 
    {
    	this.c1=new SphericCoordinate(49.55,11.0036);//(22.0, 23.0);
    	this.c2=new CartesianCoordinate(55.0, 56.0, 57.0);
       	this.c3=new SphericCoordinate(70.0, 80.0);
    	this.c4=new CartesianCoordinate(11.0, 456.0, 23.0);
    	this.c5=new NullCoordinate();
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
	assertEquals(49.55, (((SphericCoordinate) c1).getLatitude()), delta);
	assertEquals(11.0036, (((SphericCoordinate) c1).getLongitude()), delta);
	
	
	assertEquals(55, (((CartesianCoordinate) c2).getX()), delta);
	assertEquals(56, (((CartesianCoordinate) c2).getY()), delta);
	assertEquals(57, (((CartesianCoordinate) c2).getZ()), delta);
	
    }

    /**
     *
     */
    @Test
    public void testMethodIsEqual() {
    	
   CartesianCoordinate dbgpoint= c1.asCartesianCoordinate();
   SphericCoordinate dbgpoint2=dbgpoint.asSphericCoordinate(); 
  
   
   System.out.println(dbgpoint.getX()*dbgpoint.getX() + dbgpoint.getY()*dbgpoint.getY() + dbgpoint.getZ()*dbgpoint.getZ());
   
   System.out.println("dbg-point");
    	
	assertTrue(c1.isEqual(c1.asCartesianCoordinate()));
	assertTrue(c2.isEqual(c2.asCartesianCoordinate()));
	assertTrue(c3.isEqual(c3.asSphericCoordinate()));
	assertTrue(c4.isEqual(c4.asSphericCoordinate()));
	}

    @Test
    public void testMethodGetDistance() {
	
    	assertEquals(0,c1.getDistance(c1), this.delta);
    	assertEquals(0,c2.getDistance(c4), this.delta);
    	assertEquals(0,c3.getDistance(c3), this.delta);
    	assertEquals(0,c4.getDistance(c4), this.delta);
    	
    	assertEquals(0,c1.getDistance(c1.asCartesianCoordinate()), this.delta);
    	assertEquals(0,c2.getDistance(c2.asSphericCoordinate()), this.delta);

     }
    
    @Test 
    public void testNullCoordinateIsEqualsMethod()
    {
    	assertTrue(!(c5.isEqual(c5)));
    	//assertTrue(!(c1.isEqual(c5)));//geht so nicht muesste sonst in jeder Methode von isEqual ein instanceof stehen
    								//von daher nehme ich hier ein throw exception in kauf
    	
    	boolean flag=false;
    	try
    	{
    		c1.isEqual(c5);
    	}
    	catch(Throwable e)
    	{
    		flag=true;
    	}
    	
    	assertTrue(flag);
    	
    	
    	assertTrue(!(c5.isEqual(c1)));
    }

    @Test
    public void testCorrectConversion()
    {
    	assertTrue(true);//Todo einmal von spherisch zu kartesisch
    	assertTrue(true);//Todo und einmal andersrum
    }
 

	//schoener ware es wenn ichs wie in der anderen Tesetklasse von mir auf einzelene methoden aufteilen wuerde
	//da man dann gleich weis, was genau faild, hiermit weis ich nur dass die familie failt, den genauen fehler muss man dann noch lokalisieren
	//ich wollte einfach mal so einen Test schreiben, von daher hab ich des mal so gemacht^^
    @Test(expected = RuntimeException.class)
    public void testPossibleExceptions() {

    	int counter=0;
   
    	try{c5.asCartesianCoordinate();}catch(Throwable e){counter++;}
    	try{c5.asSphericCoordinate();}catch(Throwable e){counter++;}
    	
    	try{c5.getDistance(c1);}catch(Throwable e){counter++;}
    	try{c1.getDistance(c5);}catch(Throwable e){counter++;}
  
    	if(counter == 4){throw new RuntimeException("ExceptionTests fails");}


    }


   
}
