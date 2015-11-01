package org.wahlzeit.model;

import java.io.Serializable;

public abstract class Room implements Serializable{
    
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract long getFlaeche();
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract long getVolumen();
    
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract int getDoorCount();
    
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract int getWindowCount();
    
    /**
     * 
     * @return
     * @methodtype query-method
     */
    public abstract boolean Isbezeizbar();
    /**
     * 
     * @return
     * @methodtype query-method
     */
    public abstract boolean IsBeheizt();
    
    /**
     * 
     * @return
     * @methodtype getter
     */
    public abstract int getSteckdoseCount();
    
    /**
     * 
     * @return
     * @methodtype query-method
     */
    public abstract boolean IsLichtVorhanden();
    
    
    /**
     * 
     * @param beheizbar
     * @methodtype setter
     */
    public abstract void setBeheizbar(boolean beheizbar);
    //restlichen setter werden nicht fuer abstrakte schnittstelle benoetigt
    

}
