package com.example.android.gymondoautomationtest.utils

import androidx.test.internal.platform.util.TestOutputEmitter.takeScreenshot
import com.atiurin.espressopageobject.core.Description
import com.atiurin.espressopageobject.listeners.AbstractLifecycleListener

class ScreenshotLifecycleListener : AbstractLifecycleListener(){
    override fun afterFailure(description: Description, throwable: Throwable) {
        takeScreenshot(description.type.toString())
    }
}