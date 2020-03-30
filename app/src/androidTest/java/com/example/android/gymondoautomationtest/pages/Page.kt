package com.example.android.gymondoautomationtest.pages

import android.util.Log
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.espressopageobject.extensions.clearText
import com.atiurin.espressopageobject.extensions.closeSoftKeyboard
import com.atiurin.espressopageobject.extensions.typeText
import com.example.android.gymondoautomationtest.matchers.ToastMatcher
import org.hamcrest.Matcher

abstract class Page {
    /**
     * Should be called whenever a transition is performed from another screen to this screen.
     * Implementation of this method MUST include waiting for IDLE and basic checking of views.
     */
    protected abstract fun validate()

    fun isToastMessageDisplayed(text: String) {
        onView(withText(text)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    fun inputInEditText(view: Matcher<View>, text: String) {
        view.clearText()
        view.typeText(text)
        view.closeSoftKeyboard()
    }

    fun step(description: String, action: () -> Unit) {
        Log.d("Espresso step", description)
        io.qameta.allure.android.step(description){
            action()
        }
    }
}