package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

//@Subclass
public class BauartBarock extends Bauart {

    /**
     * @methodproperty primitive
     */
    @Override
    public String getName() {
	return "Barock";

    }

    /**
     * @methodproperty primitive
     */
    @Override
    public String getDescription() {
	String ret = "Als Barock (allgemein Maskulinum „der Barock“,"
		+ " aber gleichwertig Neutrum „das Barock“) wird die von etwa 1575 bis 1770 dauernde Epoche"
		+ " der europäischen Kunstgeschichte bezeichnet."
		+ " Sie wird in die Abschnitte Frühbarock (bis ca. 1650),"
		+ " Hochbarock (ca. 1650–1720) und Spätbarock oder Rokoko (ca. 1720–1770) gegliedert."
		+ " Dem Barock voraus ging die Epoche der Renaissance, ihm folgte der Klassizismus.";
	return ret;
    }

}
