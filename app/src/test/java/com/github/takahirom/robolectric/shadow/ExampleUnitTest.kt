package com.github.takahirom.robolectric.shadow

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.view.PixelCopy
import androidx.test.core.app.ActivityScenario.launch
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class ExampleUnitTest {
    @Test
    fun test() {
        // print java version
        println("System.getProperty(\"java.version\"):" + System.getProperty("java.version"))
        // java home
        println("System.getProperty(\"java.home\"):" + System.getProperty("java.home"))

        System.setProperty("robolectric.screenshot.hwrdr.native", "true")
        val activityScenario = launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            val bitmap = Bitmap.createBitmap(
                activity.window.decorView.width,
                activity.window.decorView.height,
                Bitmap.Config.ARGB_8888
            )
            PixelCopy.request(activity.window, bitmap, { copyResult ->
                if (copyResult == PixelCopy.SUCCESS) {
                    // success
                    println("success $copyResult")
                }
            }, Handler(Looper.getMainLooper()))
            bitmap.getColor(0, 0)
        }
    }
}