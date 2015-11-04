package org.wahlzeit.model;

public class Location {
    
    protected Coordinate abstrCoordinate= new NullCoordinate();
    
    /**
     * 
     * @return
     * @methodtype getter
     * @methodproperty primitive
     */
    public Coordinate getAbstrCoordinate() {
  	return abstrCoordinate;
  	
      }

    /**
     * 
     * @param abstrCoordinate
     * @methodtype (factory+)getter
     * @methodproperty primitive
     */
      public void setAbstrCoordinate(AbstractCoordinate abstrCoordinate) {
  	this.abstrCoordinate = (abstrCoordinate != null) ? abstrCoordinate : new NullCoordinate();  	

      }
    

}
