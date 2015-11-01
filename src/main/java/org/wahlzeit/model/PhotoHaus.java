package org.wahlzeit.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class PhotoHaus extends Photo implements Serializable {

    private String name; // sowas wie Villa Kunterbunt oder so....^^
    private long grundstueckGroesse; // in m²
    private int fensterCounter; // cached value
    private boolean baugenehmigungVorhanden;
    private int roomCount;
    private int bewohnerCount;
    private long baujahr; // as timestamp
    private Bauart bauart;
    private boolean bewohnbar;
    private boolean denkmalschutz;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    private long wert; // in Bitcoins, da USD, Euro, etc veraltet ist und das
		       // Fiatgeld somit bald verschwunden sein wird^^
    private long versicherungswert; // in Bitcoins

    /**
     * 
     * @param name
     * 
     * @methodtype constructor
     */
    public PhotoHaus(String name) {
	super();
	this.name = name;
    }
    
    /**
     * 
     * @param id
     * @param name
     * 
     * @methodtype constructor
     * @methodproperty composed (da super())
     */
    public PhotoHaus(PhotoId id, String name) {
	super(id);
	this.name = name;
    }
    
    /**
     * 
     * @param id
     * 
     * @methodtype constructor
     * @methodproperty composed
     */
    public PhotoHaus(PhotoId id) {
   	super(id);
       }
    
    
    /**
     * 
     * @methodtype constructor
     * @methodproperty composed
     */
    public PhotoHaus()
    {
	super();
    }
    
   /**
    *  
    * @param r
    * 
    * @methodtype command (mit teilweiser setter-logik)
    * @methodproperty composed
    */
    public void addRoom(Room r)
    {
	
	//Frage ist es allgemein besser, die Room-Liste zurueckzugeben und darauf dann zu arbeiten, 
	//oder die interne Implementierung zu verstecken und nur ueber wohldefinierte Schnittstellen nach ausen zu geben
	//-> information-hiding Prinzip aus der OOP waere damit erfuellt.
	//Meiner Meinung nach wird das ganze aber dann ziemlich "nervig", wenn man die interne Funktionalitaet beibehalten moechte
	//und nach aussen gibt ueber ganz viele solcher methoden, also so ne Art redundante Methoden "addRoom -> add von liste",
	//"removeRoom -> remove von liste", "removeAll -> clear auf liste", usw...
	//Man muss ganz vieles redundant bzw. deligierend programmieren. Kann das wirklich Sinn der Sache sein, nur um 
	//information-hiding aufrecht zu erhalten?
	
	this.rooms.add(r);
	this.roomCount++;
    }
    
    
    /**
     * 
     * @return
     * 
     * @methodtype helper
     * @methodproperty composed
     */
    private long calcGesamtHausVolumen()
    {
	//private und helper, weil eventuell wo anders noch eine derartige berechnung gebraucht wird 
	//und nicht nur im getter
	
	long gesamt=0;
	for(Room zeile : this.rooms)
	{
	   gesamt += zeile.getVolumen();
	}
	return gesamt;
    }
    
    /**
     * 
     * @return
     * 
     * @methodtype getter
     * @methodproperty composed
     */
    
    public long getGesamtHausvolumen()
    {
	return this.calcGesamtHausVolumen();
    }
    
    /**
     * 
     * @methodtype command
     * @methodproperty composed
     */
    
    public void burnDown()
    {
	this.wert=0;
	for(Room zeile : this.rooms)
	{
	   zeile.setBeheizbar(true);//etwas trolling muss sein^^
	}
	
	this.bewohnbar=false;
	this.fensterCounter=0;
	this.bauart=new BurnDownStil();
	
    }
    
    
    

    /**
     * @return the name
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     *            
     *  @methodtype setter
     *  @methodproperty primitive
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the grundstueckGroesse
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public long getGrundstueckGroesse() {
	return grundstueckGroesse;
    }

    /**
     * @param grundstueckGroesse
     *            the grundstueckGroesse to set
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setGrundstueckGroesse(long grundstueckGroesse) {
	this.grundstueckGroesse = grundstueckGroesse;
    }

    /**
     * @return the fensterCounter
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public int getFensterCounter() {
	return fensterCounter;
    }

    /**
     * @param fensterCounter
     *            the fensterCounter to set
     *        
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setFensterCounter(int fensterCounter) {
	this.fensterCounter = fensterCounter;
    }

    /**
     * @return the baugenehmigungVorhanden
     * 
     * @methodtype query-method
     * @methodproperty primitive
     */
    public boolean isBaugenehmigungVorhanden() {
	return baugenehmigungVorhanden;
    }

    /**
     * @param baugenehmigungVorhanden
     *            the baugenehmigungVorhanden to set
     *            
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBaugenehmigungVorhanden(boolean baugenehmigungVorhanden) {
	this.baugenehmigungVorhanden = baugenehmigungVorhanden;
    }

    /**
     * @return the roomCount
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public int getRoomCount() {
	return roomCount;
    }

    /**
     * @param roomCount
     *            the roomCount to set
     *   
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setRoomCount(int roomCount) {
	this.roomCount = roomCount;
    }

    /**
     * @return the bewohnerCount
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public int getBewohnerCount() {
	return bewohnerCount;
    }

    /**
     * @param bewohnerCount
     *            the bewohnerCount to set
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBewohnerCount(int bewohnerCount) {
	this.bewohnerCount = bewohnerCount;
    }

    /**
     * @return the baujahr
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public long getBaujahr() {
	return baujahr;
    }

    /**
     * @param baujahr
     *            the baujahr to set
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBaujahr(long baujahr) {
	this.baujahr = baujahr;
    }

    /**
     * @return the bauart
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public Bauart getBauart() {
	return bauart;
    }

    /**
     * @param bauart
     *            the bauart to set
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBauart(Bauart bauart) {
	this.bauart = bauart;
    }

    /**
     * @return the bewohnbar
     * 
     * @methodtype query-method
     * @methodproperty primitive
     */
    public boolean isBewohnbar() {
	return bewohnbar;
    }

    /**
     * @param bewohnbar
     *            the bewohnbar to set
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setBewohnbar(boolean bewohnbar) {
	this.bewohnbar = bewohnbar;
    }

    /**
     * @return the denkmalschutz
     * 
     * @methodtype query-method
     * @methodproperty primitive
     */
    public boolean isDenkmalschutz() {
	return denkmalschutz;
    }

    /**
     * @param denkmalschutz
     *            the denkmalschutz to set
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setDenkmalschutz(boolean denkmalschutz) {
	this.denkmalschutz = denkmalschutz;
    }

    /**
     * @return the rooms
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public ArrayList<Room> getRooms() {
	return rooms;
    }

    /**
     * @param rooms
     *            the rooms to set
     *                     
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setRooms(ArrayList<Room> rooms) {
	this.rooms = rooms;
    }

    /**
     * @return the wert
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public long getWert() {
	return wert;
    }

    /**
     * @param wert
     *            the wert to set
     * 
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setWert(long wert) {
	this.wert = wert;
    }

    /**
     * @return the versicherungswert
     * 
     * @methodtype getter
     * @methodproperty primitive
     */
    public long getVersicherungswert() {
	return versicherungswert;
    }

    /**
     * @param versicherungswert
     *            the versicherungswert to set
     *            
     * @methodtype setter
     * @methodproperty primitive
     */
    public void setVersicherungswert(long versicherungswert) {
	this.versicherungswert = versicherungswert;
    }

}
