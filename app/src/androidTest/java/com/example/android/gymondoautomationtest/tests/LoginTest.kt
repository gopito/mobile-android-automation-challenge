package com.example.android.gymondoautomationtest.tests

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.example.android.gymondoautomationtest.BaseTest
import com.example.android.gymondoautomationtest.MainActivity
import com.example.android.gymondoautomationtest.pages.LoginPage
import com.example.android.gymondoautomationtest.pages.SearchPage
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginTest : BaseTest() {
    val RIGHT_EMAIL = "automation@gymondo.de"
    val RIGHT_PASSWORD = "automation"

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setUp() {
        mActivityRule.launchActivity(Intent())
    }

    @Test
    fun rightLoginPassword() {
        LoginPage {
            inputEmail(RIGHT_EMAIL)
            inputPassword(RIGHT_PASSWORD)
            tapLogin()
        }
        SearchPage {
        }
    }

    @Test
    fun emptyLoginPassword() {
        LoginPage {
            tapLogin()
            isToastMessageDisplayed("Username and/or password incorrect")
        }
        LoginPage {
        }
    }

    @Test
    fun wrongLoginPassword() {
        LoginPage {
            inputEmail("wrong")
            inputPassword("wrong")
            tapLogin()
            isToastMessageDisplayed("Username and/or password incorrect")
        }
        LoginPage {
        }
    }
}

