package fractions

import myLibraries.bigger
import myLibraries.divides
import java.lang.IllegalArgumentException


class Fraction{

	//Fields
	var numerator:Int
		private set
	var denominator:Int
		private set

	//Constructors

	constructor(_numerator:Int, _denominator:Int){
		if(_numerator==0 && _denominator==0)
			throw IllegalArgumentException("Parameter must != 0")
		
		if(_denominator>0){
			denominator = _denominator
			numerator = _numerator
		}else{
			numerator
			denominator = -_denominator
		}

	}


	//Primary functions

	fun simplify(){
		for(divider in 1..(numerator bigger denominator))
			reduceOrNope(divider)
	}


	//Arithmetical actions
	/**
	 * Checks, whether this fraction can be reduced by [reducer]
	 *
	 * @param must be > 0
	 * @return Can this fraction be reduced by [reducer]?
	 * @throws IllegalArgumentException Parameter must > 0
	 */

	infix fun reducibleOn(reducer: Int): Boolean {
		return numerator divides reducer && denominator divides reducer
	}

	/**
	 * Tries to reduce the function by [reducer]
	 *
	 * @param
	 */
	@ExperimentalUnsignedTypes
	fun reduceOrNope(reducer: Int){

		if(this reducibleOn reducer){
			numerator /= reducer.toInt()
			denominator /= reducer.toInt()
		}
	}
}