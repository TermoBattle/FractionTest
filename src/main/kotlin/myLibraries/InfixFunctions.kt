package myLibraries

/**
 * @return [this]%[other] == 0?
 */
infix fun Int.divides(other:Int) = this % other==0
/**
 * @return [this]%[other] == 0?
 */
infix fun Int.divides(other:UInt) = this % other.toInt()==0
/**
 * @return [this]%[other] == 0?
 */
infix fun UInt.divides(other:Int) = toInt() % other==0
/**
 * @return [this]%[other] == 0?
 */
infix fun <T> UInt.divides(other: UInt) = toInt() % other.toInt() == 0

/**
 * @return [this]%[other] == 0?
 */
infix fun Long.divides(other:Long) = this % other==0L
/**
 * @return [this]%[other] == 0?
 */
infix fun Long.divides(other:ULong) = this % other.toLong()==0L
/**
 * @return [this]%[other] == 0?
 */
infix fun ULong.divides(other:Long) = toLong() % other==0L
/**
 * @return [this]%[other] == 0?
 */
infix fun ULong.divides(other:ULong) = toLong() % other.toLong()==0L


/**
 * @return [this]%[other] == 0?
 */
infix fun Float.divides(other:Float) = this % other==0f


/**
 * @return [this]%[other] == 0?
 */
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
