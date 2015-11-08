package org.wahlzeit.model;

public class DistanceCalculatorService implements DistanceCalculatorVisitor<SphericCoordinate, Void> {
    private Double result = null;

    /**
     * @return the result
     * 
     * @methodtype get
     */
    public double getResult() {
	if (result == null) {
	    throw new RuntimeException("Ergebnis wurde noch nicht berechnet");
	}
	return result.doubleValue();
    }

    /**
     * 
     * @param c1
     * @param c2
     * 
     * @methodtype command
     */
    public void execute(Coordinate c1, Coordinate c2) {
	SphericCoordinate tmp1 = c1.accept(this, null);
	SphericCoordinate tmp2 = c2.accept(this, null);

	this.result = new Double(
		doCalculation(tmp1.getLongitude(), tmp1.getLatitude(), tmp2.getLongitude(), tmp2.getLatitude()));
    }

    /**
     * 
     * @param varLonA
     * @param varLatA
     * @param varLongB
     * @param varLatB
     * @return
     * 
     * @methodtype helper
     */
    public double doCalculation(double varLonA, double varLatA, double varLongB, double varLatB) {
	return Math.acos(Math.sin(varLatA) * Math.sin(varLatB)
		+ Math.cos(varLatA) * Math.cos(varLatB) * Math.cos(Math.abs(varLongB - varLonA)));
    }

    public SphericCoordinate visit(SphericCoordinate sc, Void leer) {
	return sc;
    }

    public SphericCoordinate visit(CartesianCoordinate cc, Void leer) {
	double varLat = Math.atan2(cc.getY(), cc.getX());
	double varLong = Math.PI / 2 - Math.atan(cc.getZ() / Math.sqrt(cc.getX() * cc.getX() + cc.getY() * cc.getY()));
	return new SphericCoordinate(varLat, varLong);
    }

    // folgendes geht leider nicht, catcht leider alles, schade eigentlich, aber
    // ok.....
    /*
     * @Override public SphericCoordinate visit(Object var, Void
     * einWeitererParameter) { //catch muell
     * System.out.println(var.getClass().getName()); return this.visit(var,
     * einWeitererParameter); //return null; }
     */

}
