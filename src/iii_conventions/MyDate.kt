package iii_conventions

import iii_conventions.nextDay

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.compareTo(other: MyDate): Int {
    if(this.year == other.year) {
        if(this.month == other.month) {
            return this.dayOfMonth - other.dayOfMonth
        }
        return this.month - other.month
    }
    return this.year - other.year
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object:Iterator<MyDate> {
            var next = start
            override fun hasNext(): Boolean {
                return next <= endInclusive
            }

            override fun next(): MyDate {
                val current = next
                next = this.next.nextDay()
                return current
            }

        }
    }
}

operator fun DateRange.contains(lookingFor: MyDate): Boolean
        = lookingFor.compareTo(start) >= 0 && lookingFor.compareTo(endInclusive) <= 0
