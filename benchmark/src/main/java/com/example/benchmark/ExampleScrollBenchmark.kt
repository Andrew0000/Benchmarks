package com.example.benchmark

import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleScrollBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun scrollSimpleShadows() = benchmarkRule.measureRepeated(
        packageName = "com.example.benchmarks",
        metrics = listOf(FrameTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
        device.waitForIdle()
        val btn = device.findObject(By.res("nav_to_simple_shadows"))
        btn.click()
        device.waitForIdle()
        val list = device.findObject(By.res("main_scroll"))
        list.fling(Direction.DOWN)
    }

    @Test
    fun scrollRealisticShadows() = benchmarkRule.measureRepeated(
        packageName = "com.example.benchmarks",
        metrics = listOf(FrameTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
        device.waitForIdle()
        val btn = device.findObject(By.res("nav_to_realistic_shadows"))
        btn.click()
        device.waitForIdle()
        val list = device.findObject(By.res("main_scroll"))
        list.fling(Direction.DOWN)
    }
}