package com.example.android.gymondoautomationtest.pages

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.espressopageobject.extensions.click
import com.atiurin.espressopageobject.extensions.closeSoftKeyboard
import com.atiurin.espressopageobject.extensions.isDisplayed
import com.atiurin.espressopageobject.recyclerview.withRecyclerView
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.actions.SearchAction
import com.example.android.gymondoautomationtest.matchers.HelperMatchers
import org.hamcrest.Matcher

class SearchPage : Page {
    val SEARCH_HINT = "Search for exercise"

    constructor(action: SearchPage.() -> Unit) {
        validate()
        this.action()
    }

    constructor() {
        validate()
    }

    private val exerciseList = withId(R.id.recycler_view)
    private val searchField = withId(R.id.editTxtSearch)
    private val searchButton = withId(R.id.btnSearch)
    private val clearButton = withId(R.id.btnClear)

    override fun validate() {
        searchField.isDisplayed()
        withHint(SEARCH_HINT).isDisplayed()
        searchButton.isDisplayed()
        clearButton.isDisplayed()
        exerciseList.isDisplayed()
    }

    fun closeKeyboard() {
        searchField.closeSoftKeyboard()
    }

    private fun inputSearchQuery(text: String) {
        inputInEditText(searchField, text)
    }

    fun makeSearch(text: String): Set<String>{
        inputSearchQuery(text)
        searchButton.click()
        return getExercises()
    }

    fun getItemsCount(): Int {
        return withRecyclerView(exerciseList).getSize()
    }

    fun clearSearch(){
        clearButton.click()
    }


    fun getExercises(): Set<String> {
        val exerciseListAction = SearchAction()
        onView(exerciseList).perform(exerciseListAction)
        return exerciseListAction.exercises
    }

    fun waitForFirstItem(){
        (HelperMatchers.atPosition(0,
                withId(R.id.item_text)) as Matcher<View>).isDisplayed()}

}