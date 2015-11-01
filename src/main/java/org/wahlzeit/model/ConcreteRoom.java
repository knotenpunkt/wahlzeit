package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

//@Entity
public class ConcreteRoom extends Room {

    private long flaeche=0;
    private long volumen=0;
    private int doorCount=0;
    private int windowCount=0;
    private boolean beheizbar=false;
    private boolean beheizt=false;
    private int steckdoseCount=0;
    private boolean lichtVorhanden=false;
    
    
    
    /**
     * 
     * @param flaeche
     * @param volumen
     * @param doorCount
     * @param windowCount
     * @param beheizbar
     * @param beheizt
     * @param steckdoseCount
     * @param lichtVorhanden
     * 
     * @methodtype constructor
     * @methodproperty constructor, composed
     */
    public ConcreteRoom(long flaeche, long volumen, int doorCount, int windowCount, boolean beheizbar, boolean beheizt,
	    int steckdoseCount, boolean lichtVorhanden) {
	super();
	this.flaeche = flaeche;
	this.volumen = volumen;
	this.doorCount = doorCount;
	this.windowCount = windowCount;
	this.beheizbar = beheizbar;
	this.beheizt = beheizt;
	this.steckdoseCount = steckdoseCount;
	this.lichtVorhanden = lichtVorhanden;
    }
    
    /**
     * @methodtype constructor
     * @methodproperty constructor, composed
     */
    public ConcreteRoom()
    {
	super();
    }
    
    
    

    /**
     * @param flaeche the flaeche to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setFlaeche(long flaeche) {
        this.flaeche = flaeche;
    }




    /**
     * @param volumen the volumen to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setVolumen(long volumen) {
        this.volumen = volumen;
    }




    /**
     * @param doorCount the doorCount to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }




    /**
     * @param windowCount the windowCount to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setWindowCount(int windowCount) {
        this.windowCount = windowCount;
    }




    /**
     * @param beheizbar the beheizbar to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBeheizbar(boolean beheizbar) {
        this.beheizbar = beheizbar;
    }




    /**
     * @param beheizt the beheizt to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBeheizt(boolean beheizt) {
        this.beheizt = beheizt;
    }




    /**
     * @param lichtVorhanden the lichtVorhanden to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setLichtVorhanden(boolean lichtVorhanden) {
        this.lichtVorhanden = lichtVorhanden;
    }




    @Override
    /**
     * @methodproperty primitive
     */
    public long getFlaeche() {
	return this.flaeche;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public long getVolumen() {
	return this.volumen;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public int getDoorCount() {
	return this.doorCount;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public int getWindowCount() {
	return this.windowCount;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public boolean Isbezeizbar() {
	return this.beheizbar;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public boolean IsBeheizt() {
	return this.beheizt;
    }


    /**
     * @methodproperty primitive
     */
    @Override
    public int getSteckdoseCount() {
	return this.steckdoseCount;
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public boolean IsLichtVorhanden() {
	return this.lichtVorhanden;
    }

}
