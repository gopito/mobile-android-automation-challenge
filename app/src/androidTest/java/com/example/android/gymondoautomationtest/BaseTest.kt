package com.example.android.gymondoautomationtest

import com.atiurin.espressopageobject.core.action.ViewActionLifecycle
import com.atiurin.espressopageobject.core.assertion.ViewAssertionLifecycle
import com.example.android.gymondoautomationtest.utils.ScreenshotLifecycleListener
import io.qameta.allure.espresso.FailshotRule
import io.qameta.allure.espresso.LogcatClearRule
import io.qameta.allure.espresso.LogcatDumpRule
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.RuleChain

open class BaseTest(){
//attach screenshot to allure report in case of failure
    @get:Rule
    val failshot = FailshotRule()

    //attach logcat to allure report in case of failure
    @get:Rule
    val ruleChain = RuleChain.outerRule(LogcatClearRule()).around(LogcatDumpRule())

    companion object{
        @BeforeClass
        @JvmStatic
        fun beforeClass(){
            var listener = ScreenshotLifecycleListener()
            ViewActionLifecycle.addListener(listener)
            ViewAssertionLifecycle.addListener(listener)
        }
    }
}