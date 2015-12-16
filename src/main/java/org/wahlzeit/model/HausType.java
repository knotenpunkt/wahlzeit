package org.wahlzeit.model;

public class HausType {

	private boolean luxusSegment;
	private long preisklasse;
	private String luxuxBezeichnung;

	public HausType(boolean luxusSegment, long preisklasse,
			String luxuxBezeichnung) {
		this.luxusSegment = luxusSegment;
		this.preisklasse = preisklasse;
		this.luxuxBezeichnung = luxuxBezeichnung;
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
