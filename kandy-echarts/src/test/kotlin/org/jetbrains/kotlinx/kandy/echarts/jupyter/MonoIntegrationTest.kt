/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.echarts.jupyter

import org.jetbrains.kotlinx.jupyter.testkit.JupyterReplTestCase
import org.junit.Rule
import org.junit.rules.TestName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// This test doesn't support other libraries, to have possibility to add them, provide custom REPL provider
// to the testcase constructor
class MonoIntegrationTest : JupyterReplTestCase() {
    @JvmField
    @Rule
    val testName: TestName = TestName()

    private val classLoader = (this::class as Any).javaClass.classLoader

    @Test
    fun `echarts plot should render normally`() {
        val plotHtml = execHtml("""
            plot(mapOf()) {
                line {
                    label {
                        position = LabelPosition.fromPct(10.pct to 10.pct, -90)
                        formatter = "{b}"
                        textStyle.color = Color.named("blue")
                        border {
                            color = Color.hex("#CCC")
                            width = .5
                        }
                    }
                }
            }
        """.trimIndent())

        assertOutput(plotHtml)
    }

    private fun assertOutput(actualOutputText: String?) {
        assertNotNull(actualOutputText)
        val resourcePath = "testData/jupyter/${testName.methodName}.out"
        val resource = classLoader.getResource(resourcePath)
        assertNotNull(resource)
        assertEquals(resource.readText().replace("\r\n", "\n"), actualOutputText)
    }
}
