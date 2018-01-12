package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange =
        DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate =
        addTimeIntervals(interval, 1)

operator fun MyDate.plus(pair: Pair<TimeInterval, Int>): MyDate =
        addTimeIntervals(pair.first, pair.second)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(int: Int): Pair<TimeInterval, Int> = Pair(this, int)

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dataRange: DateRange) : Iterator<MyDate> {
    var curDate: MyDate = dataRange.start

    override fun hasNext(): Boolean = curDate <= dataRange.endInclusive

    override fun next(): MyDate {
        val oldData = curDate
        curDate = curDate.nextDay()
        return oldData
    }
}

operator fun DateRange.contains(d: MyDate) : Boolean = when {
    start <= d && d <= endInclusive -> true
    start > endInclusive -> false
    else -> false
}
