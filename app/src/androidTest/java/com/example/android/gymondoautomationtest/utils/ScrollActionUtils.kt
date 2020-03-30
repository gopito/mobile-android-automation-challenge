package com.example.android.gymondoautomationtest.utils

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.UiThread
import androidx.test.espresso.UiController
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation

object ScrollActionUtils {
    private const val BOTTOM_FACTOR = 250
    private const val TOP_FACTOR = 50
    private const val SCROLL_FACTOR = 2

    val deviceScreenSize: Point
        get() {
            val display =
                getInstrumentation().targetContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val size = Point()
            display.defaultDisplay.getSize(size)
            return size
        }

    fun getVisibleRect(view: View, origin: CoordinateOrigin): Rect {
        val globalOffset = Point()
        val visibleRect = Rect()
        view.getGlobalVisibleRect(visibleRect, globalOffset)
        visibleRect.offset(-globalOffset.x, -globalOffset.y)
        if (origin == CoordinateOrigin.SCREEN) {
            val xy = IntArray(2)
            view.getLocationOnScreen(xy)
            visibleRect.offset(xy[0], xy[1])
        }
        return visibleRect
    }

    @UiThread
    fun scrollDown(
        uiController: UiController,
        view: ViewGroup
    ) {
        val size =
            deviceScreenSize
        val listVisibleRect =
            getVisibleRect(
                view,
                CoordinateOrigin.SCREEN
            )
        sendSwipe(
            uiController, view,
            size.x / 2,
            listVisibleRect.bottom - BOTTOM_FACTOR,
            size.x / 2,
            listVisibleRect.bottom - listVisibleRect.bottom / SCROLL_FACTOR
        )
        uiController.loopMainThreadUntilIdle()
    }

    @UiThread
    fun sendSwipe(
        uiController: UiController,
        view: ViewGroup,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ) {
        GeneralSwipeAction(
            Swipe.SLOW,
            CoordinatesProvider { floatArrayOf(fromX.toFloat(), fromY.toFloat()) },
            CoordinatesProvider { floatArrayOf(toX.toFloat(), toY.toFloat()) },
            Press.FINGER
        )
            .perform(uiController, view)
    }

    enum class CoordinateOrigin {
        /**
         * Coordinates are given relative to view.
         */
        LOCAL,
        /**
         * Coordinates are given relative to the device screen.
         */
        SCREEN
    }
}