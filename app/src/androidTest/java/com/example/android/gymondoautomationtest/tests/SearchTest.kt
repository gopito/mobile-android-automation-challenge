package com.example.android.gymondoautomationtest.tests

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.example.android.gymondoautomationtest.BaseTest
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.pages.SearchPage
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchTest : BaseTest() {
    lateinit var allExercises: Set<String>

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(ListActivity::class.java, false, false)

    @Before
    fun setUp() {
        mActivityRule.launchActivity(Intent())
        SearchPage {
            closeKeyboard()
            waitForFirstItem()
            allExercises = getExercises()
        }
    }

    @Test
    fun multiItemsSearchTest() {
        SearchPage {
            val exercisesAfterSearch = makeSearch("2")
            val filteredExercises = allExercises.filterTo(HashSet()) { it.contains("2") }
            Assert.assertEquals(filteredExercises, exercisesAfterSearch)
        }
    }

    @Test
    fun noItemsSearchTest() {
        SearchPage {
            makeSearch("wrong text for search")
            Assert.assertEquals(0, getItemsCount())
        }
    }

    @Test
    fun clearSearchResultTest() {
        SearchPage {
            makeSearch("22")
            clearSearch()
            val exercisesAfterClear = getExercises()
            Assert.assertEquals(allExercises, exercisesAfterClear)
        }
    }
}