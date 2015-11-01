package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

//@Subclass
public class BurnDownStil extends Bauart {

    /**
     * @methodproperty primitive
     */
    @Override
    public String getName() {
	return "BurnDown";
    }

    /**
     * @methodproperty primitive
     */
    @Override
    public String getDescription() {
	return "Der BurnDown-Stil bezeichnet Haeuser, die nur noch aus Schutt und Asche bestehen, also niedergebrannt (worden) sind";
    }

}
