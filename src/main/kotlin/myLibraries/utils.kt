package myLibraries

fun Int.splitToMultipliers():List<Int>{
    var value:Int = this
    val multipliers = emptyList<Int>().toMutableList()

    for(divider in 1..this)
        if (value divides divider){
            multipliers+=divider
            value/=divider
        }

    return multipliers
}