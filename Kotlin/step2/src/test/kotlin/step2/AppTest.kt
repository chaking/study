/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package step2

import hello.kotlin.lib.Lib
import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = Lib()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}