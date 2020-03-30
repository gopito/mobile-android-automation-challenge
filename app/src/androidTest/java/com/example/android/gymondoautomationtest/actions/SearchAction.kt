package com.example.android.gymondoautomationtest.actions

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.android.gymondoautomationtest.utils.ScrollActionUtils
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher


class SearchAction() : ViewAction {
    val exercises = mutableSetOf<String>()
    override fun perform(uiController: UiController?, view: View) {
        view as RecyclerView
        for (position in 0 until view.adapter?.itemCount!!) {
            var item = view.layoutManager?.findViewByPosition(position)
            if (item == null) {
                ScrollActionUtils.scrollDown(uiController!!, view)
                item = view.layoutManager?.findViewByPosition(position)
            }
            exercises.add((item as TextView).text.toString())
        }
    }

    override fun getDescription(): String {
        return "get list of exercises"
    }

    override fun getConstraints(): Matcher<View> {
        return allOf(isDisplayed(), isAssignableFrom(RecyclerView::class.java))
    }
}