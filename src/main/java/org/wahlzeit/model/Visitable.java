package org.wahlzeit.model;

import org.wahlzeit.Pattern;


@Pattern(
		name = "Visitor", 
		participants = { 
				"Element" //Teilnehmer=this, siehe accept-Methode
				})
public interface Visitable<T, K, A, B> {

	/**
	 * 
	 * @param v
	 * @param ein_weiterer_parameter
	 * @return
	 * 
	 * @methodtype helper
	 */
	public T accept(DistanceCalculatorVisitor<A, B> v, K ein_weiterer_parameter);

}
