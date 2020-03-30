package com.example.android.gymondoautomationtest.matchers

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object HelperMatchers {
    fun <T> atPosition(
        position: Int,
        matcher: Matcher<T>
    ): Matcher<T>? {
        return object : BaseMatcher<T>() {
            var matchingPosition = 0
            override fun matches(item: Any): Boolean {
                if (!matcher.matches(item)) {
                    return false
                }
                return matchingPosition++ == position
            }

            override fun describeTo(description: Description) {
                description.appendText("should return matching item at position $position")
            }
        }
    }
}