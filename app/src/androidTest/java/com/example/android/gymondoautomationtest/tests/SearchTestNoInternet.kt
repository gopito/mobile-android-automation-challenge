package com.example.android.gymondoautomationtest.tests

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.example.android.gymondoautomationtest.BaseTest
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.pages.SearchPage
import com.linkedin.android.testbutler.TestButler
import org.junit.*

class SearchTestNoInternet : BaseTest() {
    lateinit var allExercises: Set<String>

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(ListActivity::class.java, false, false)

    @Before
    fun setUp() {
        TestButler.setWifiState(false)
        TestButler.setGsmState(false)
        mActivityRule.launchActivity(Intent())
        SearchPage {
            closeKeyboard()
            allExercises = getExercises()
        }
    }

    @Test
    fun searchWithoutWifi() {
        SearchPage {
            isToastMessageDisplayed("Call failed")
            Assert.assertEquals(0, getItemsCount())
            makeSearch("2")
            Assert.assertEquals(0, getItemsCount())
        }

    }

    @After
    fun tearDown() {
        TestButler.setWifiState(true)
        TestButler.setGsmState(true)
    }


}