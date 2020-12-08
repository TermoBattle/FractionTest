package fractions

import myLibraries.bigger
import myLibraries.divides
import java.lang.IllegalArgumentException

/**
 * Works like an ordinary fraction
 * @property [numerator] upper part of [Fraction], stores its sign
 * @property [denominator] lower part of [Fraction]
 *
 * @constructor Calculates its sign and put it to the [numerator]
 * @throws IllegalArgumentException "Parameter must != 0"
 */
class MutableFraction(_numerator: Int, _denominator: Int) {

	//Fields and Initializers
	var numerator:Int
		private set
	var denominator:Int
		private set

	init {
		if(_numerator==0 && _denominator==0)
			throw IllegalArgumentException("Parameter must != 0")
		if(_denominator>0){
			denominator = _denominator
			numerator = _numerator
		}else{
			numerator = -_numerator
			denominator = -_denominator
		}
	}

	/**
	 * Reduces the [Fraction] as much as possible
	 */
	@ExperimentalUnsignedTypes
	fun simplify(){
		for(divider in 1.toUInt()..(numerator bigger denominator).toUInt())
			reduceOrNope(divider)
	}

	/**
	 * Checks, can this fraction can be reduced by [reducer]
	 *
	 * @param [reducer] must be > 0
	 * @return Can [Fraction] be reduced by [reducer]?
	 * @throws IllegalArgumentException "Parameter must > 0"
	 */
	@ExperimentalUnsignedTypes
	infix fun reducibleOn(reducer: UInt):Boolean = (numerator divides reducer) && (denominator divides reducer)
	/**
	 * Tries to reduce the function by [reducer]
	 * @param [reducer] must be > 0
	 */
	@ExperimentalUnsignedTypes
	fun reduceOrNope(reducer: UInt) {
		if (this reducibleOn reducer) {
			numerator /= reducer.toInt()
			denominator /= reducer.toInt()
		}
	}


	override fun toString() = "$numerator/$denominator"

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Fraction

		if (numerator != other.numerator) return false
		if (denominator != other.denominator) return false

		return true
	}

	override fun hashCode(): Int {
		var result = numerator
		result = 31 * result + denominator
		return result
	}

	operator fun plus(other: Fraction): Fraction {
		if (denominator == other.denominator)
			return Fraction(numerator+other.numerator,denominator)

		val first = times(other.denominator)
		val second = other * denominator
	}
	operator fun times(other:Int) = Fraction(numerator*other,denominator*other)
}