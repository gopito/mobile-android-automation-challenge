package com.example.android.gymondoautomationtest

import android.os.Bundle
import com.linkedin.android.testbutler.TestButler
import io.qameta.allure.espresso.AllureAndroidRunner


class CustomRunner : AllureAndroidRunner() {
    override fun onStart() {
        TestButler.setup(targetContext)
        super.onStart()
    }

    override fun finish(resultCode: Int, results: Bundle) {
        TestButler.teardown(targetContext)
        super.finish(resultCode, results)
    }
}