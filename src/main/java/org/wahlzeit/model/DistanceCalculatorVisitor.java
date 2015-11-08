package org.wahlzeit.model;

public interface DistanceCalculatorVisitor<T , K> {

    /**
     * 
     * @param v
     * @param einWeitererParameter
     * @return
     * 
     * @methodtype helper
     */
    public T visit(SphericCoordinate v, K einWeitererParameter);
    
    /**
     * 
     * @param v
     * @param einWeitererParameter
     * @return
     * 
     * @methodtype helper
     */
    public T visit(CartesianCoordinate v, K einWeitererParameter);
    
    //public T visit(Object var, K einWeitererParameter); 
    
}
