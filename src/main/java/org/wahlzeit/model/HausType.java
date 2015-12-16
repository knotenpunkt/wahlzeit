package org.wahlzeit.model;

public class HausType {

	private boolean luxusSegment;
	private long preisklasse;
	private String luxuxBezeichnung;

	public HausType(boolean luxusSegment, long preisklasse,
			String luxuxBezeichnung) {
		this.luxusSegment = luxusSegment; //wird das ganze schon als luxus gewertet, oder eben nicht
		this.preisklasse = preisklasse; //preisklasse 50 000 bedeutet bspw. ne Preisrange von 40-60K USD 
		this.luxuxBezeichnung = luxuxBezeichnung; //bspw. Villa
	}

	public Haus createInstance() {
		return new Haus(this);
	}
	
	

	public boolean isLuxusSegment() {
		return luxusSegment;
	}

	public void setLuxusSegment(boolean luxusSegment) {
		this.luxusSegment = luxusSegment;
	}

	public long getPreisklasse() {
		return preisklasse;
	}

	public void setPreisklasse(long preisklasse) {
		this.preisklasse = preisklasse;
	}

	public String getLuxuxBezeichnung() {
		return luxuxBezeichnung;
	}

	public void setLuxuxBezeichnung(String luxuxBezeichnung) {
		this.luxuxBezeichnung = luxuxBezeichnung;
	}
	
	
	
	
	
	

}
