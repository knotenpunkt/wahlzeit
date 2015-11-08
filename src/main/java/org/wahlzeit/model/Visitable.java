package org.wahlzeit.model;

public interface Visitable<T, K, A, B> {

    /**
     * 
     * @param v
     * @param ein_weiterer_parameter
     * @return
     * 
     * @methodtype helper
     */
    public T accept(DistanceCalculatorVisitor<A,B> v, K ein_weiterer_parameter);
    
}
