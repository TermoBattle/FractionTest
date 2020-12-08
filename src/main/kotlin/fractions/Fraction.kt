package fractions

import java.lang.IllegalArgumentException

class Fraction(numerator: Int, denominator: Int) {

    //Fields and Initializers
    var numerator:Int
        private set
    val denominator:Int
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
}