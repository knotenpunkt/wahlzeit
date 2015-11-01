package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

//@Subclass
public class BauartNormal extends Bauart{

    /**
     * @methodproperty primitive
     */
    @Override
    public String getName() {
	return "Normal";
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public String getDescription() {
	String ret="Als Normale Bauart wird diese Bauart bezeichnet, die ab 1990 vorzufinden ist. "
		+ "Ein anderer Name waere auch 'Heutige Bauart'. "
		+ "Dies wurde im Kontext des Wahlzeitprojekts von Knotenpunkt so definiert.";
	return ret;
    }
   

}
