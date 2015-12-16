package org.wahlzeit.model;

public class Haus {

	private HausType hausType;
	private PhotoHaus photoHaus=null;//Back-Referenz zum Photo, falls Photo vorhanden
	
	
	//ist hiermit redundant, da ich diese attribute damals schon direkt dem photoHaus gegeben habe 
	//(und sinnlos weil ich ueber die backreferenz eh an die attribute komme)
	//eigentlich ist diese Hausaufgabe fuer mich ueberfluessig, 
	//da ich mit PhotoHaus und bspw. Baurt/Bautyp eigentlich schon ne Variante 
	//vom Type-Objekt-Pattern implementiert hatte
	//Jetzt hab ichs halt teilweise redundant nochmal und ein bisschen anders gemacht.
	//Du kannst dir aber gerne meine Bauart Klasse ansehen und auch wie ich das ganze damit verwirklicht hatte - damals.
	
	private String name; // sowas wie Villa Kunterbunt oder so....^^
	private long baujahr; // as timestamp
	private int bewohnerCount;
	
	
	
	public Haus(HausType ht)
	{
		this.hausType=ht;
	}
	
	/**
	 * 
	 * Eine sehr schoene moeglichkeit waehrend der Laufzeit den Typ zu aendern
	 * Das waere beim normalen Java-Inheritance nicht moeglich^^
	 */
	public void setHaustype(HausType ht)
	{
		this.hausType=ht;
	}
	
	public HausType getHaustype()
	{
		return this.hausType;
	}
	
	
	/**
	 * 
	 * sogar eine Art Mehrfachverebung kann man so umsetzen^^
	 * Habe ich aber jetzt nicht weiter ausgefuehrt....
	 */
	/*
	public void setOneMoreHaustype(HausType ht)
	{
		//Arrayliste.set(...)
	}
	*/
	
	
	
	//beispielmethode(n) wie man mit den daten aus Haustype umgeht
	public double getCalculatedPreisForEachBewohner()
	{
		return this.doCalculatePreisForEachBewohner();
	}
	
	private double doCalculatePreisForEachBewohner()
	{
		return this.bewohnerCount/this.getHaustype().getPreisklasse();
	}	
	
	
	public void setPhotoHaus(PhotoHaus photoHaus)
	{
		this.photoHaus=photoHaus;
	}
	
	public PhotoHaus getPhotoHaus(PhotoHaus photoHaus)
	{
		return this.photoHaus;
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
	 * @methodtype setter
	 * @methodproperty primitive
	 */
	public void setName(String name) {
		this.name = name;
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

	
	
	
	
	
	
	
	
	
}
