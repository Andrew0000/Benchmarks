package com.example.benchmarks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.IntOffset
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.benchmarks.ui.theme.BenchmarksTheme

const val DEFAULT_TRANSITION_DURATION_MILLISECOND = 700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BenchmarksTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .semantics {
                            testTagsAsResourceId = true
                        }
                ) {
                    val backStackList = rememberNavBackStack<NavDest>(NavDest.Home)

                    val entryProvider = entryProvider<Any> {

                        entry<NavDest.Home> { HomeScreen() }

                        entry<NavDest.SimpleShadowsWithScroll> { ScrollableShadowsScreen(simple = true) }

                        entry<NavDest.RealisticShadowsWithScroll> { ScrollableShadowsScreen(simple = false) }
                    }

                    val backStackMediator = remember { BackStackMediator(backStackList) }
                    CompositionLocalProvider(LocalBackStack provides backStackMediator) {
                        NavDisplay(
                            backStack = backStackList,
                            modifier = Modifier.fillMaxSize(),
                            entryProvider = entryProvider,
                            onBack = { count ->
                                repeat(count) {
                                    if (backStackList.isNotEmpty()) {
                                        backStackList.removeLastOrNull()
                                    }
                                }
                            },
                            transitionSpec = {
                                ContentTransform(
                                    slideIn(
                                        animationSpec = tween(
                                            DEFAULT_TRANSITION_DURATION_MILLISECOND
                                        ),
                                        initialOffset = { IntOffset(it.width, 0) },
                                    ),
                                    slideOut(
                                        animationSpec = tween(
                                            DEFAULT_TRANSITION_DURATION_MILLISECOND
                                        ),
                                        targetOffset = { IntOffset(-it.width, 0) },
                                    ),
                                )
                            },
                            popTransitionSpec = {
                                ContentTransform(
                                    slideIn(
                                        animationSpec = tween(
                                            DEFAULT_TRANSITION_DURATION_MILLISECOND
                                        ),
                                        initialOffset = { IntOffset(-it.width, 0) },
                                    ),
                                    slideOut(
                                        animationSpec = tween(
                                            DEFAULT_TRANSITION_DURATION_MILLISECOND
                                        ),
                                        targetOffset = { IntOffset(it.width, 0) },
                                    ),
                                )
                            },
                        )
                    }
                }
            }
        }
    }
}
