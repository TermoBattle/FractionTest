package fractions

val Fraction.isShortenable:Boolean
	get(){
		for(divider in 1..(numerator bigger denominator))
			if(this divides divider)
           	return false
           return true
    }