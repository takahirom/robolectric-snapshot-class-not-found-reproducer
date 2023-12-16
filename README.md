```kotlin
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
```

./gradlew :app:testDebugUnitTest


```
java.lang.NoClassDefFoundError: java/nio/NioUtils
	at android.media.ImageReader$SurfaceImage$SurfacePlane.clearBuffer(ImageReader.java:1389)
	at android.media.ImageReader$SurfaceImage.clearSurfacePlanes(ImageReader.java:1333)
	at android.media.ImageReader.releaseImage(ImageReader.java:690)
	at android.media.ImageReader$SurfaceImage.close(ImageReader.java:1171)
	at android.media.ImageReader.close(ImageReader.java:801)
	at org.robolectric.shadows.HardwareRenderingScreenshot.takeScreenshot(HardwareRenderingScreenshot.java:90)
	at org.robolectric.shadows.ShadowPixelCopy.takeScreenshot(ShadowPixelCopy.java:171)
	at org.robolectric.shadows.ShadowPixelCopy.request(ShadowPixelCopy.java:96)
	at org.robolectric.shadows.ShadowPixelCopy.request(ShadowPixelCopy.java:74)
	at android.view.PixelCopy.request(PixelCopy.java)
	at com.github.takahirom.robolectric.shadow.ExampleUnitTest.test$lambda$1(ExampleUnitTest.kt:33)
	at androidx.test.core.app.ActivityScenario.lambda$onActivity$2$androidx-test-core-app-ActivityScenario(ActivityScenario.java:789)
	at androidx.test.core.app.ActivityScenario$$ExternalSyntheticLambda2.run(D8$$SyntheticClass)
	at androidx.test.core.app.ActivityScenario.onActivity(ActivityScenario.java:799)
	at com.github.takahirom.robolectric.shadow.ExampleUnitTest.test(ExampleUnitTest.kt:27)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:588)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:290)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:101)
	at java.base/java.util.concurrent.FutureTask.run(Unknown Source)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at java.base/java.lang.Thread.run(Unknown Source)
Caused by: java.lang.ClassNotFoundException: java.nio.NioUtils
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(Unknown Source)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(Unknown Source)
	at java.base/java.lang.ClassLoader.loadClass(Unknown Source)
	at org.robolectric.internal.bytecode.SandboxClassLoader.loadClass(SandboxClassLoader.java:138)
	at java.base/java.lang.ClassLoader.loadClass(Unknown Source)
	at android.media.ImageReader$SurfaceImage$SurfacePlane.$$robo$$android_media_ImageReader_SurfaceImage_SurfacePlane$clearBuffer(ImageReader.java:1389)
	at android.media.ImageReader$SurfaceImage$SurfacePlane.clearBuffer(ImageReader.java)
	at android.media.ImageReader$SurfaceImage.$$robo$$android_media_ImageReader_SurfaceImage$clearSurfacePlanes(ImageReader.java:1333)
	at android.media.ImageReader$SurfaceImage.clearSurfacePlanes(ImageReader.java)
	at android.media.ImageReader.$$robo$$android_media_ImageReader$releaseImage(ImageReader.java:690)
	at android.media.ImageReader.releaseImage(ImageReader.java)
	at android.media.ImageReader$SurfaceImage.$$robo$$android_media_ImageReader_SurfaceImage$close(ImageReader.java:1171)
	at android.media.ImageReader$SurfaceImage.close(ImageReader.java)
	at android.media.ImageReader.$$robo$$android_media_ImageReader$close(ImageReader.java:801)
	at android.media.ImageReader.close(ImageReader.java)
	at org.robolectric.shadows.HardwareRenderingScreenshot.takeScreenshot(HardwareRenderingScreenshot.java:90)
	at org.robolectric.shadows.ShadowPixelCopy.takeScreenshot(ShadowPixelCopy.java:171)
	at org.robolectric.shadows.ShadowPixelCopy.request(ShadowPixelCopy.java:96)
	at org.robolectric.shadows.ShadowPixelCopy.request(ShadowPixelCopy.java:74)
	at android.view.PixelCopy.request(PixelCopy.java)
	at com.github.takahirom.robolectric.shadow.ExampleUnitTest.test$lambda$1(ExampleUnitTest.kt:33)
	at androidx.test.core.app.ActivityScenario.lambda$onActivity$2$androidx-test-core-app-ActivityScenario(ActivityScenario.java:789)
	at androidx.test.core.app.ActivityScenario$$ExternalSyntheticLambda2.run(D8$$SyntheticClass)
	at androidx.test.core.app.ActivityScenario.onActivity(ActivityScenario.java:799)
	at com.github.takahirom.robolectric.shadow.ExampleUnitTest.test(ExampleUnitTest.kt:27)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.base/java.lang.reflect.Method.invoke(Unknown Source)
	... 12 more
```