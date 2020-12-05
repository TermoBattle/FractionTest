package myLibraries

infix fun Int.divides(other:Int) = this % other==0
@ExperimentalUnsignedTypes
infix fun  UInt.divides(other: UInt) = this.toInt() % other.toInt() == 0
infix fun Long.divides(other:Long) = this % other==0L
infix fun Float.divides(other:Float) = this % other==0f
infix fun Double.divides(other:Double) = this % other==0.0

/**
 * @receiver Must be [T]: [Number]
 * @param Must be [T]: [Number]
 *
 * @return Largest [T], [this] or [other]
 */
infix fun <T:Number> T.bigger(other:T): T {
    this as Long
    other as Long
    return if(this>other)
               this
           else
               other
}
